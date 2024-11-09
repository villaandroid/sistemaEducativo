package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pensums")
public class Pensums {
    @Id
    private Long pens_id;
    private Long prog_id; 
    private String pens_periodo;

    public Pensums() {}

    public Pensums(Long pens_id, Long prog_id, String pens_periodo) {
        this.pens_id = pens_id;
        this.prog_id = prog_id;
        this.pens_periodo = pens_periodo;
    }

    public Long getPens_id() {
        return pens_id;
    }

    public void setPens_id(Long pens_id) {
        this.pens_id = pens_id;
    }

    public Long getProg_id() {
        return prog_id;
    }

    public void setProg_id(Long prog_id) {
        this.prog_id = prog_id;
    }

    public String getPens_periodo() {
        return pens_periodo;
    }

    public void setPens_periodo(String pens_periodo) {
        this.pens_periodo = pens_periodo;
    }
}
