package com.jaideravila01.SE.service;

import com.jaideravila01.SE.model.VsEstudiante;
import com.jaideravila01.SE.repository.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstudianteImpl implements ServicioEstudiante {

    @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public List<VsEstudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public VsEstudiante obtenerEstudiantePorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<VsEstudiante> obtenerAsignaturasPorEstudianteId(Long estudianteId) {
        return repositorio.findAllByEstudianteId(estudianteId);
    }
}
