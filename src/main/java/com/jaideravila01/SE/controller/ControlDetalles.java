package com.jaideravila01.SE.controller;


import com.jaideravila01.SE.model.VsEstudiante;
import com.jaideravila01.SE.service.ServicioEstudiante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControlDetalles {

    @Autowired
    private ServicioEstudiante servicioEstudiante;

    @GetMapping("terceros/info/{id}")
    public String mostrarDetalles(@PathVariable("id") Long id, Model model) {
        List<VsEstudiante> listaAsignaturas = servicioEstudiante.obtenerAsignaturasPorEstudianteId(id);
        
        if (!listaAsignaturas.isEmpty()) {
            VsEstudiante estudiante = listaAsignaturas.get(0);
            model.addAttribute("estudiante", estudiante);
            model.addAttribute("asignaturas", listaAsignaturas);
            return "infoTercero";
        } else {
            // Redirige a la página específica de "Estudiante no matriculado"
            model.addAttribute("mensajeError", "El estudiante aún no está matriculado.");
            return "NoMatriculado";
        }
    }
    
}
