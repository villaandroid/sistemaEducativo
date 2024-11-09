package com.jaideravila01.SE.service;

import java.util.List;
import com.jaideravila01.SE.model.Grupo;

public interface GrupoServicio {
    List<Grupo> listarTodosLosGrupos();
    Grupo obtenerGrupoPorId(Long id);
    void guardarGrupo(Grupo grupo);
    void eliminarGrupo(Long id);

    
    
}
