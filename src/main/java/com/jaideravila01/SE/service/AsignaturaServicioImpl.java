package com.jaideravila01.SE.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaideravila01.SE.model.Asignatura;
import com.jaideravila01.SE.repository.AsignaturasRepositorio;

@Service
public class AsignaturaServicioImpl implements AsignaturaServicio {

    @Autowired
    private AsignaturasRepositorio repositorio;

    @Override
    public List<Asignatura> listarAsignaturas() {
        return repositorio.findAll();
    }

    @Override
    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return repositorio.save(asignatura);
    }

    @Override
    public Asignatura obteneAsignaturaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarAsignatura(Long id) {
        repositorio.deleteById(id);
    }
}
