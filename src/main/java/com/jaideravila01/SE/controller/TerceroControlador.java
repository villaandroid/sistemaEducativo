package com.jaideravila01.SE.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

    // Mostrar formulario para agregar
    @GetMapping("/terceros/nuevo")
    public String crearTerceroFormulario(Model modelo) {
        modelo.addAttribute("tercero", new Tercero());
        modelo.addAttribute("accion", "Agregar");
        return "form_terceros";
    }

    // Guardar nuevo tercero
    @PostMapping("/terceros")
    public String guardarTercero(@ModelAttribute("tercero") Tercero tercero) {
        servicio.guardarTercero(tercero);
        return "redirect:/terceros";
    }

    // Mostrar formulario para editar
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

            terceroExistente.setTerc_tipo_doc(tercero.getTerc_tipo_doc());
            terceroExistente.setTerc_nro_doc(tercero.getTerc_nro_doc());
            terceroExistente.setTerc_nombres(tercero.getTerc_nombres());
            terceroExistente.setTerc_apellidos(tercero.getTerc_apellidos());
            terceroExistente.setTerc_fecha_nac(tercero.getTerc_fecha_nac());
            terceroExistente.setTerc_genero(tercero.getTerc_genero());
            terceroExistente.setTerc_correo(tercero.getTerc_correo());
            terceroExistente.setTerc_tipo(tercero.getTerc_tipo());

            servicio.guardarTercero(terceroExistente);
        }

        return "redirect:/terceros";
    }

    // Eliminar tercero
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
}