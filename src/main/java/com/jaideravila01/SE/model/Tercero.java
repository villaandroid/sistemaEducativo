package com.jaideravila01.SE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "terceros")
public class Tercero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terc_id;

    @Column(name = "terc_tipo_doc", nullable = false, length = 2)
    private String terc_tipo_doc;

    @Column(name = "terc_nro_doc", nullable = false, length = 10)
    private String terc_nro_doc;

    @Column(name = "terc_nombres", nullable = false, length = 50)
    private String terc_nombres;

    @Column(name = "terc_apellidos", nullable = false, length = 50)
    private String terc_apellidos;

    @Column(name = "terc_fecha_nac")
    private Date terc_fecha_nac;

    @Column(name = "terc_genero", nullable = false, length = 1)
    private String terc_genero;

    @Column(name = "terc_correo", nullable = false, length = 50)
    private String terc_correo;

    @Column(name = "terc_tipo", nullable = false, length = 1)
    private String terc_tipo;

    @Column(name = "terc_estado", nullable = false, length = 1)
    private String terc_estado;

    public Tercero() {
    }

    public Tercero(String terc_tipo_doc, String terc_nro_doc, String terc_nombres, String terc_apellidos,
            Date terc_fecha_nac, String terc_genero, String terc_correo, String terc_tipo, String terc_estado) {
        this.terc_tipo_doc = terc_tipo_doc;
        this.terc_nro_doc = terc_nro_doc;
        this.terc_nombres = terc_nombres;
        this.terc_apellidos = terc_apellidos;
        this.terc_fecha_nac = terc_fecha_nac;
        this.terc_genero = terc_genero;
        this.terc_correo = terc_correo;
        this.terc_tipo = terc_tipo;
        this.terc_estado = terc_estado;
    }

    public Long getTerc_id() {
        return terc_id;
    }

    public void setTerc_id(Long terc_id) {
        this.terc_id = terc_id;
    }

    public String getTerc_tipo_doc() {
        return terc_tipo_doc;
    }

    public void setTerc_tipo_doc(String terc_tipo_doc) {
        this.terc_tipo_doc = terc_tipo_doc;
    }

    public String getTerc_nro_doc() {
        return terc_nro_doc;
    }

    public void setTerc_nro_doc(String terc_nro_doc) {
        this.terc_nro_doc = terc_nro_doc;
    }

    public String getTerc_nombres() {
        return terc_nombres;
    }

    public void setTerc_nombres(String terc_nombres) {
        this.terc_nombres = terc_nombres;
    }

    public String getTerc_apellidos() {
        return terc_apellidos;
    }

    public void setTerc_apellidos(String terc_apellidos) {
        this.terc_apellidos = terc_apellidos;
    }

    public Date getTerc_fecha_nac() {
        return terc_fecha_nac;
    }

    public void setTerc_fecha_nac(Date terc_fecha_nac) {
        this.terc_fecha_nac = terc_fecha_nac;
    }

    public String getTerc_genero() {
        String mensaje = "";
        if ("M".equalsIgnoreCase(this.terc_genero)) {
            mensaje = "MASCULINO";
        } else if ("F".equalsIgnoreCase(this.terc_genero)) {
            mensaje = "FEMENINO";
        } else {
            mensaje = "OTR@";
        }

        return mensaje;
    }

    public void setTerc_genero(String terc_genero) {
        this.terc_genero = terc_genero;
    }

    public String getTerc_correo() {
        return terc_correo;
    }

    public void setTerc_correo(String terc_correo) {
        this.terc_correo = terc_correo;
    }

    public String getTerc_tipo() {
        return terc_tipo;
    }

    public void setTerc_tipo(String terc_tipo) {
        this.terc_tipo = terc_tipo;
    }

    public String getTerc_estado() {
        return terc_estado;
    }

    public void setTerc_estado(String terc_estado) {
        this.terc_estado = terc_estado;
    }

    
}
