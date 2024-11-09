package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asig_id;

    private String asig_codigo;
    private String asig_asignatura;
    private Long asig_creditos;
    private Long asig_horas;

    public Asignatura() {
    }

    public Asignatura(String asig_codigo, String asig_asignatura, Long asig_creditos, Long asig_horas) {
        this.asig_codigo = asig_codigo;
        this.asig_asignatura = asig_asignatura;
        this.asig_creditos = asig_creditos;
        this.asig_horas = asig_horas;
    }

    public Long getAsig_id() {
        return asig_id;
    }

    public void setAsig_id(Long asig_id) {
        this.asig_id = asig_id;
    }

    public String getAsig_codigo() {
        return asig_codigo;
    }

    public void setAsig_codigo(String asig_codigo) {
        this.asig_codigo = asig_codigo;
    }

    public String getAsig_asignatura() {
        return asig_asignatura;
    }

    public void setAsig_asignatura(String asig_asignatura) {
        this.asig_asignatura = asig_asignatura;
    }

    public Long getAsig_creditos() {
        return asig_creditos;
    }

    public void setAsig_creditos(Long asig_creditos) {
        this.asig_creditos = asig_creditos;
    }

    public Long getAsig_horas() {
        return asig_horas;
    }

    public void setAsig_horas(Long asig_horas) {
        this.asig_horas = asig_horas;
    }

}
