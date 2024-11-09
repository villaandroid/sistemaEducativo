package com.jaideravila01.SE.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaideravila01.SE.model.Grupo;
import com.jaideravila01.SE.repository.GrupoRepositorio;

@Service
public class GrupoServicioImpl implements GrupoServicio {

    @Autowired
    private GrupoRepositorio repositorio;

    @Override
    public List<Grupo> listarTodosLosGrupos() {
        return repositorio.findAll();
    }

    @Override
    public Grupo obtenerGrupoPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarGrupo(Grupo grupo) {
        repositorio.save(grupo);
    }

    @Override
    public void eliminarGrupo(Long id) {
        repositorio.deleteById(id);
    }
}
