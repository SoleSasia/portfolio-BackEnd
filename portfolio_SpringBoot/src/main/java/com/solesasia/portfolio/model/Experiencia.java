
package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Experiencia implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String puestoExpe;
    private String periodoExpe;
    private String organismoExpe;
    private String descripcionExpe;
    private String urlLogoExpe;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    //private Long personaId;

    public Experiencia() {
    }

    public Experiencia(String puestoExpe, String periodoExpe, String organismoExpe, String descripcionExpe, String urlLogoExpe) {
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.organismoExpe = organismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
        
    }

}
