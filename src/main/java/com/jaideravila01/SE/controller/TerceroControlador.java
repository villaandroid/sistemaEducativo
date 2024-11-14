package com.jaideravila01.SE.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaideravila01.SE.model.Tercero;
import com.jaideravila01.SE.service.TerceroServicio;

@Controller
public class TerceroControlador {

    @Autowired
    private TerceroServicio servicio;

    // Listar
    @GetMapping("/terceros")
    public String listarTerceros(Model modelo) {
        modelo.addAttribute("terceros", servicio.listarTodosLosTerceros());
        return "terceros";
    }

    // formulario para agregar
    @GetMapping("/terceros/nuevo")
    public String crearTerceroFormulario(Model modelo) {
        modelo.addAttribute("tercero", new Tercero());
        modelo.addAttribute("accion", "Agregar");
        return "form_terceros";
    }

    // Guardar
    @PostMapping("/terceros")
    public String guardarTercero(@ModelAttribute("tercero") Tercero tercero, Model modelo) {
        try {
            servicio.guardarTercero(tercero);
            return "redirect:/terceros";
        } catch (DataIntegrityViolationException e) {
            modelo.addAttribute("error", "El número de documento ya existe. Por favor, ingrese uno diferente.");
            modelo.addAttribute("tercero", tercero); // Retener datos del formulario
            modelo.addAttribute("accion", "Agregar");
            return "form_terceros";
        }
    }

    // formulario para editar
    @GetMapping("/terceros/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        Tercero tercero = servicio.obtenerTerceroPorId(id);
        modelo.addAttribute("tercero", tercero);
        modelo.addAttribute("accion", "Editar");
        return "form_terceros";
    }

    @PostMapping("/terceros/{id}")
    public String actualizarTercero(@PathVariable Long id, @ModelAttribute("tercero") Tercero tercero) {
        Tercero terceroExistente = servicio.obtenerTerceroPorId(id);

        if (terceroExistente != null) {
            Tercero terceroActualizado = new Tercero(
                    tercero.getTerc_tipo_doc(),
                    tercero.getTerc_nro_doc(),
                    tercero.getTerc_nombres(),
                    tercero.getTerc_apellidos(),
                    tercero.getTerc_fecha_nac(),
                    tercero.getTerc_genero(),
                    tercero.getTerc_correo(),
                    tercero.getTerc_tipo(),
                    tercero.getTerc_estado());

            terceroActualizado.setTerc_id(terceroExistente.getTerc_id());

            servicio.guardarTercero(terceroActualizado);
        }

        return "redirect:/terceros";
    }

    // Eliminar
    @GetMapping("/terceros/eliminar/{id}")
    public String eliminarTercero(@PathVariable Long id) {
        servicio.eliminarTercero(id);
        return "redirect:/terceros";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(formatoFecha, true));
    }

    @GetMapping("/terceros/cambiarEstado/{id}")
    public String cambiarEstadoTercero(@PathVariable Long id, Model modelo) {
        Tercero tercero = servicio.obtenerTerceroPorId(id);

        if (tercero != null) {

            if ("0".equals(tercero.getTerc_estado())) {
                tercero.setTerc_estado("1");
            } else {
                tercero.setTerc_estado("0");
            }
            servicio.guardarTercero(tercero);
        }

        return "redirect:/terceros";
    }

}