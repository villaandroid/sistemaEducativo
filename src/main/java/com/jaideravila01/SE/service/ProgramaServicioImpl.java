package com.jaideravila01.SE.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaideravila01.SE.model.Programa;
import com.jaideravila01.SE.repository.ProgramaRepositorio;

@Service
public class ProgramaServicioImpl implements ProgramaServicio {

    @Autowired
    private ProgramaRepositorio repositorio;

    @Override
    public List<Programa> listarTodosLosProgramas() {
        return repositorio.findAll();
    }

    @Override
    public Programa guardarPrograma(Programa programa) {
        return repositorio.save(programa);
    }

    @Override
    public Programa obtenerPrograma(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Programa actualizarPrograma(Programa programa) {
        return repositorio.save(programa);
    }

    @Override
    public void eliminarPrograma(Long id) {
        repositorio.deleteById(id);
    }


    @Override
    public String obtenerNombreProgramaPorId(Long id) {
        Programa programa = repositorio.findById(id).orElse(null);
        return programa != null ? programa.getProg_programa() : "Programa no encontrado";
    }

    @Override
    public long contarProgramas() {
        return repositorio.count();
    }
}
