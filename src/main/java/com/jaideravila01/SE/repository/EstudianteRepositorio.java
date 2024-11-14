package com.jaideravila01.SE.repository;

import com.jaideravila01.SE.model.VsEstudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<VsEstudiante, Long> {
    List<VsEstudiante> findAllByEstudianteId(Long estudianteId);
}
