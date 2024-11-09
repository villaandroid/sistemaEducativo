package com.jaideravila01.SE.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.jaideravila01.SE.model.Aula;
import com.jaideravila01.SE.repository.AulaRepositorio;

@Service
public class AulaServicioImpl implements AulaServicio {

    @Autowired
    private AulaRepositorio repositorio;

    @Override
    public List<Aula> listarAulas() {
        return repositorio.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Aula guardarAula(Aula aula) {
        return repositorio.save(aula);
    }

    @Override
    public Aula obtenerAulaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarAula(Long id) {
        repositorio.deleteById(id);
    }
}
