package com.jaideravila01.SE.service;

import java.util.List;
import com.jaideravila01.SE.model.Programa;

public interface ProgramaServicio {
    List<Programa> listarTodosLosProgramas();
    Programa guardarPrograma(Programa programa);
    Programa obtenerPrograma(Long id);
    Programa actualizarPrograma(Programa programa);
    void eliminarPrograma(Long id);
    String obtenerNombreProgramaPorId(Long id);
    public long contarProgramas();

}
