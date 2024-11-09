package com.jaideravila01.SE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaideravila01.SE.model.Programa;

@Repository
public interface ProgramaRepositorio extends JpaRepository<Programa, Long>{
    
}
