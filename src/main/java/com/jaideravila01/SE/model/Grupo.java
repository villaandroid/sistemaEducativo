package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupos")

public class Grupo {
    /*
     * grup_id number,
     * terc_id number,
     * asig_id number,
     * grup_periodo varchar2(6),
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long grup_id;
    Long terc_id;
    Long asig_id;
    String grup_periodo;

    public Grupo() {

    }

    public Grupo(Long grup_id, Long terc_id, Long asig_id, String grup_periodo) {
        this.grup_id = grup_id;
        this.terc_id = terc_id;
        this.asig_id = asig_id;
        this.grup_periodo = grup_periodo;
    }

    public Long getGrup_id() {
        return grup_id;
    }

    public void setGrup_id(Long grup_id) {
        this.grup_id = grup_id;
    }

    public Long getTerc_id() {
        return terc_id;
    }

    public void setTerc_id(Long terc_id) {
        this.terc_id = terc_id;
    }

    public Long getAsig_id() {
        return asig_id;
    }

    public void setAsig_id(Long asig_id) {
        this.asig_id = asig_id;
    }

    public String getGrup_periodo() {
        return grup_periodo;
    }

    public void setGrup_periodo(String grup_periodo) {
        this.grup_periodo = grup_periodo;
    }

    

}