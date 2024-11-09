package com.jaideravila01.SE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jaideravila01.SE.model.Pensums;
import com.jaideravila01.SE.service.PensumServicio;
import com.jaideravila01.SE.service.ProgramaServicio;

import java.util.ArrayList;

@Controller
@RequestMapping("/pensums")
public class PensumControlador {

    @Autowired
    private PensumServicio pensumServicio;

    @Autowired
    private ProgramaServicio programaServicio;

    @GetMapping
    public String listarPensums(Model modelo) {
        ArrayList<Pensums> pensums = new ArrayList<>(pensumServicio.listarTodosLosPensums());
        ArrayList<String> nombresProgramas = new ArrayList<>();

        for (Pensums pensum : pensums) {
            String nombrePrograma = programaServicio.obtenerNombreProgramaPorId(pensum.getProg_id());
            nombresProgramas.add(nombrePrograma);
        }

        modelo.addAttribute("pensums", pensums);
        modelo.addAttribute("nombresProgramas", nombresProgramas);
        return "pensums";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model modelo) {
        modelo.addAttribute("pensum", new Pensums());
        modelo.addAttribute("programas", programaServicio.listarTodosLosProgramas());
        return "form_pensums";
    }

    @PostMapping
    public String guardarPensum(@ModelAttribute("pensum") Pensums pensum) {
        pensumServicio.guardarPensum(pensum);
        return "redirect:/pensums";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("pensum", pensumServicio.obtenerPensumPorId(id));
        modelo.addAttribute("programas", programaServicio.listarTodosLosProgramas());
        return "form_pensums";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPensum(@PathVariable Long id) {
        pensumServicio.eliminarPensum(id);
        return "redirect:/pensums";
    }
}
