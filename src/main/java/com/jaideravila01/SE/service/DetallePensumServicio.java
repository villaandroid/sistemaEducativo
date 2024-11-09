package com.jaideravila01.SE.service;

import org.springframework.stereotype.Service;

import com.jaideravila01.SE.model.Asignatura;

import java.util.List;

@Service
public interface DetallePensumServicio {
    Long obtenerPensumPorTercero(Long tercId); // Método para obtener el pensum del estudiante
    String obtenerPeriodoPorTercero(Long tercId); // Método para obtener el período académico
    List<Asignatura> obtenerAsignaturasPorPensum(Long pensId); // Método para obtener las asignaturas de un pensum
}