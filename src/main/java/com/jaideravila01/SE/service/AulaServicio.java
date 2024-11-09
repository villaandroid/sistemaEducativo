package com.jaideravila01.SE.service;

import java.util.List;
import com.jaideravila01.SE.model.Aula;

public interface AulaServicio {
    List<Aula> listarAulas();
    Aula guardarAula(Aula aula);
    Aula obtenerAulaPorId(Long id);
    void eliminarAula(Long id);
}
