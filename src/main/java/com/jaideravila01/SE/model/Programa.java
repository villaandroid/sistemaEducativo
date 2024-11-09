package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programas")
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long prog_id;

 
    private String prog_programa;

    
    public Programa(){
    }

   
    public Programa(String prog_programa) {
       
        this.prog_programa = prog_programa;
    }

    public Long getProg_id() {
        return prog_id;
    }

    public void setProg_id(Long prog_id) {
        this.prog_id = prog_id;
    }

    public String getProg_programa() {
        return prog_programa;
    }

    public void setProg_programa(String prog_programa) {
        this.prog_programa = prog_programa;
    }

    
}
