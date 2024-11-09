package com.jaideravila01.SE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaideravila01.SE.service.ProgramaServicio;
import com.jaideravila01.SE.service.TerceroServicio;



@Controller
public class MainControlle {

    @Autowired
  private TerceroServicio terceroServicio;

  @Autowired
  private ProgramaServicio programaServicio;

    @GetMapping({"/", "/index"})
    public String mostrarInicio(Model modelo) {
        long totalTerceros = terceroServicio.contarTerceros();
        long totalProgramas = programaServicio.contarProgramas();
        modelo.addAttribute("totalTerceros", totalTerceros);
        modelo.addAttribute("totalProgramas", totalProgramas);
        return "index"; 
    }
}
