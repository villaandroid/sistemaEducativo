package com.jaideravila01.SE.service;

import java.util.List;

import com.jaideravila01.SE.model.Pensums;

public interface PensumServicio {
    List<Pensums> listarTodosLosPensums();
    Pensums obtenerPensumPorId(Long id);
    void guardarPensum(Pensums pensum);
    void eliminarPensum(Long id);
}