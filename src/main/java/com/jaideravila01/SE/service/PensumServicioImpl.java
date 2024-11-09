package com.jaideravila01.SE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaideravila01.SE.model.Pensums;
import com.jaideravila01.SE.repository.PensumRepositorio;

@Service
public class PensumServicioImpl implements PensumServicio {

    @Autowired
    private PensumRepositorio repositorio;

    @Override
    public List<Pensums> listarTodosLosPensums() {
        return repositorio.findAll();
    }

    @Override
    public Pensums obtenerPensumPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarPensum(Pensums pensum) {
        repositorio.save(pensum);
    }

    @Override
    public void eliminarPensum(Long id) {
        repositorio.deleteById(id);
    }
}
