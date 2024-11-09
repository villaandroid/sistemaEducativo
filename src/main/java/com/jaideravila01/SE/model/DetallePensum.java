package com.jaideravila01.SE.model;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pensums")
public class DetallePensum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pens_id", nullable = false)
    private Long pensId;

    @Column(name = "asig_id", nullable = false)
    private Long asigId;

    @Column(name = "depe_nivel", nullable = true)
    private String depeNivel;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPensId() { return pensId; }
    public void setPensId(Long pensId) { this.pensId = pensId; }

    public Long getAsigId() { return asigId; }
    public void setAsigId(Long asigId) { this.asigId = asigId; }

    public String getDepeNivel() { return depeNivel; }
    public void setDepeNivel(String depeNivel) { this.depeNivel = depeNivel; }
}
