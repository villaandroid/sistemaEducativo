package com.jaideravila01.SE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaideravila01.SE.model.Asignatura;
import com.jaideravila01.SE.service.AsignaturaServicio;

@Controller
public class AsignaturaControlador {

    @Autowired
    private AsignaturaServicio servicio;

    @GetMapping("/asignaturas")
    public String listarAsignaturas(Model modelo) {
        System.out.println("Listando asignaturas");
        modelo.addAttribute("asignaturas", servicio.listarAsignaturas());
        return "asignaturas";
    }

    @GetMapping("/asignaturas/nuevo")
    public String crearAsignaturaFormulario(Model modelo) {
        System.out.println("Creando formulario para nueva asignatura");
        modelo.addAttribute("asignatura", new Asignatura());
        modelo.addAttribute("accion", "Agregar");
        return "form_asignatura";
    }

    // guardar
    @PostMapping("/asignaturas")
    public String guardarAsignatura(@ModelAttribute("asignatura") Asignatura asignatura) {
        servicio.guardarAsignatura(asignatura);
        return "redirect:/asignaturas";
    }

    // form para editar
    @GetMapping("/asignaturas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        Asignatura asignatura = servicio.obteneAsignaturaPorId(id);
        modelo.addAttribute("asignatura", asignatura);
        modelo.addAttribute("accion", "Editar");
        return "form_asignatura";
    }

    // actulaizar
    @PostMapping("/asignaturas/{id}")
    public String actualizarAsignatura(@PathVariable Long id, @ModelAttribute("asignatura") Asignatura asignatura) {

        Asignatura asignaturaActualizada = new Asignatura(
                asignatura.getAsig_codigo(),
                asignatura.getAsig_asignatura(),
                asignatura.getAsig_creditos(),
                asignatura.getAsig_horas()

        );

        asignaturaActualizada.setAsig_id(id);
        servicio.guardarAsignatura(asignaturaActualizada);

        return "redirect:/asignaturas";
    }

    @GetMapping("/asignaturas/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Long id) {
        servicio.eliminarAsignatura(id);
        return "redirect:/asignaturas";
    }
}
