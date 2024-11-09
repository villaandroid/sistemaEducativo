package com.jaideravila01.SE.service;

import java.util.List;
import com.jaideravila01.SE.model.Asignatura;

public interface AsignaturaServicio {
    List<Asignatura> listarAsignaturas();
    Asignatura guardarAsignatura(Asignatura asignatura);
    Asignatura obteneAsignaturaPorId(Long id);
    void eliminarAsignatura(Long id);
}
