package com.jaideravila01.SE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jaideravila01.SE.model.Programa;
import com.jaideravila01.SE.service.ProgramaServicio;

@Controller
public class ProgramaControlador {

    @Autowired
    private ProgramaServicio servicio;

    @GetMapping("/programas")
    public String listarProgramas(Model modelo) {
        modelo.addAttribute("programas", servicio.listarTodosLosProgramas());
        return "programas";
    }

     // agreagr
    @GetMapping("/programas/nuevo")
    public String crearProgramaFormulario(Model modelo) {
        Programa programa = new Programa();
        modelo.addAttribute("programa", programa);
        modelo.addAttribute("accion", "Agregar");
        return "form_programas";
    }

    @PostMapping("/programas")
    public String guardarPrograma(@ModelAttribute("programa") Programa programa) {
        servicio.guardarPrograma(programa);
        return "redirect:/programas";
    }

   // formulario para editare
    @GetMapping("/programas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        Programa programa = servicio.obtenerPrograma(id);
        modelo.addAttribute("programa", programa);
        modelo.addAttribute("accion", "Editar");
        return "form_programas";
    }

    // Actualizar
    @PostMapping("/programas/{id}")
    public String actualizarPrograma(@PathVariable Long id, @ModelAttribute("programa") Programa programa) {
        Programa programaExistente = servicio.obtenerPrograma(id);

        Programa programaActualizado = new Programa(programa.getProg_programa());

        programaActualizado.setProg_id(programaExistente.getProg_id());
        servicio.guardarPrograma(programaActualizado);

        return "redirect:/programas";
    }


    @GetMapping("/programas/eliminar/{id}")
    public String eliminarPrograma(@PathVariable Long id) {
        servicio.eliminarPrograma(id);;
        return "redirect:/programas";
    }
}
