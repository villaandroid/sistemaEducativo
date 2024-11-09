package com.jaideravila01.SE.service;

import java.util.List;

import com.jaideravila01.SE.model.Tercero;


public interface TerceroServicio {
    List<Tercero> listarTodosLosTerceros();
    Tercero guardarTercero(Tercero tercero);
    Tercero obtenerTerceroPorId(Long id);
    Tercero actualizarTercero(Tercero tercero);
    void eliminarTercero(Long id);
    public long contarTerceros();


}