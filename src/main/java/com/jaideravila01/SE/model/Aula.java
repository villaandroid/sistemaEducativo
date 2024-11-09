package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aula_id")
    private Long id;

    @Column(name = "aula_bloque", length = 2, nullable = false)
    private String bloque;

    @Column(name = "aula_aula", length = 4, nullable = false)
    private String aula;

    @Column(name = "aula_descrip", length = 50)
    private String descripcion;

  

    public Aula(){
        
    }

    

    public Aula( String bloque, String aula, String descripcion) {
      
        this.bloque = bloque;
        this.aula = aula;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
