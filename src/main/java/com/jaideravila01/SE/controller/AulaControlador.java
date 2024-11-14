package com.jaideravila01.SE.controller;

import com.jaideravila01.SE.model.Aula;
import com.jaideravila01.SE.service.AulaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AulaControlador {

    @Autowired
    private AulaServicio servicio;

    // Listar
    @GetMapping("/aulas")
    public String listarAulas(Model modelo) {
        modelo.addAttribute("aulas", servicio.listarAulas());
        System.out.println(servicio.listarAulas());
        return "aulas";
    }

    // mostrar formulario
    @GetMapping("/aulas/nueva")
    public String crearAulaFormulario(Model modelo) {
        modelo.addAttribute("aula", new Aula());
        modelo.addAttribute("accion", "Agregar");
        return "form_aula";
    }

    // Guardar 
    @PostMapping("/aulas")
    public String guardarAula(@ModelAttribute("aula") Aula aula) {
        servicio.guardarAula(aula);
        return "redirect:/aulas";
    }

    //editar existente
    @GetMapping("/aulas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Aula aula = servicio.obtenerAulaPorId(id);
        modelo.addAttribute("aula", aula);
        modelo.addAttribute("accion", "Editar");
        return "form_aula";
    }

    // Actualizar 
    @PostMapping("/aulas/{id}")
    public String actualizarAula(@PathVariable Long id, @ModelAttribute("aula") Aula aula) {
        Aula aulaActualizada = new Aula(
            aula.getBloque(),
            aula.getAula(),
            aula.getDescripcion()
        );
        aulaActualizada.setId(id); //obtener id existente

        servicio.guardarAula(aulaActualizada);
        return "redirect:/aulas";
    }

    // Eliminar
    @GetMapping("/aulas/eliminar/{id}")
    public String eliminarAula(@PathVariable Long id) {
        servicio.eliminarAula(id);
        return "redirect:/aulas";
    }
}
