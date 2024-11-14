package com.jaideravila01.SE.service;

import com.jaideravila01.SE.model.VsEstudiante;
import java.util.List;

public interface ServicioEstudiante {
    List<VsEstudiante> listarEstudiantes();
    VsEstudiante obtenerEstudiantePorId(Long id);
    public List<VsEstudiante> obtenerAsignaturasPorEstudianteId(Long estudianteId);
}
