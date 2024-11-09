package com.jaideravila01.SE.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaideravila01.SE.model.Tercero;
import com.jaideravila01.SE.repository.TerceroRepositorio;

@Service
public class TerceroServicioImpl implements TerceroServicio {

    @Autowired
    private TerceroRepositorio repositorio;

    @Override
    public List<Tercero> listarTodosLosTerceros() {
        return repositorio.findAll();
    }

    @Override
    public Tercero guardarTercero(Tercero tercero) {
        return repositorio.save(tercero);
    }

    @Override
    public Tercero obtenerTerceroPorId(Long id) {
        return repositorio.findById(id).orElse(null);

    }

    @Override
    public Tercero actualizarTercero(Tercero tercero) {
        return repositorio.save(tercero);
    }

    @Override
    public void eliminarTercero(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public long contarTerceros() {
        return repositorio.count();
    }

}