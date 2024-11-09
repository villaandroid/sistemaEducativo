package com.jaideravila01.SE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jaideravila01.SE.model.Grupo;
import com.jaideravila01.SE.model.Tercero;
import com.jaideravila01.SE.model.Asignatura;
import com.jaideravila01.SE.service.GrupoServicio;
import com.jaideravila01.SE.service.TerceroServicio;
import com.jaideravila01.SE.service.AsignaturaServicio;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/grupos")
public class GrupoControlador {

    @Autowired
    private GrupoServicio grupoServicio;

    @Autowired
    private TerceroServicio terceroServicio;

    @Autowired
    private AsignaturaServicio asignaturaServicio;


    private List<Tercero> obtenerProfesores() {
        List<Tercero> todosLosTerceros = terceroServicio.listarTodosLosTerceros();
        List<Tercero> profesores = new ArrayList<>();
        
        for (Tercero tercero : todosLosTerceros) {
            if ("1".equals(tercero.getTerc_tipo())) {
                profesores.add(tercero);
            }
        }
        return profesores;
    }

    @GetMapping
    public String listarGrupos(Model modelo) {
        List<Grupo> grupos = grupoServicio.listarTodosLosGrupos();
        List<String> nombresTerceros = new ArrayList<>();
        List<String> nombresAsignaturas = new ArrayList<>();

        for (Grupo grupo : grupos) {
            Tercero profesor = terceroServicio.obtenerTerceroPorId(grupo.getTerc_id());
            if (profesor != null ) {
                String nombreCompleto = profesor.getTerc_nombres() + " " + profesor.getTerc_apellidos();
                nombresTerceros.add(nombreCompleto);
            }

            Asignatura asignatura = asignaturaServicio.obteneAsignaturaPorId(grupo.getAsig_id());
            if (asignatura != null) {
                nombresAsignaturas.add(asignatura.getAsig_asignatura());
            }
        }

        modelo.addAttribute("grupos", grupos);
        modelo.addAttribute("nombresTerceros", nombresTerceros);
        modelo.addAttribute("nombresAsignaturas", nombresAsignaturas);
        return "grupos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model modelo) {
        modelo.addAttribute("grupo", new Grupo());
        modelo.addAttribute("terceros", obtenerProfesores());
        modelo.addAttribute("asignaturas", asignaturaServicio.listarAsignaturas());
        return "form_grupo";
    }

    @PostMapping
    public String guardarGrupo(@ModelAttribute("grupo") Grupo grupo) {
        grupoServicio.guardarGrupo(grupo);
        return "redirect:/grupos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("grupo", grupoServicio.obtenerGrupoPorId(id));
        modelo.addAttribute("terceros", obtenerProfesores());
        modelo.addAttribute("asignaturas", asignaturaServicio.listarAsignaturas());
        return "form_grupo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarGrupo(@PathVariable Long id) {
        grupoServicio.eliminarGrupo(id);
        return "redirect:/grupos";
    }


    
}
