
package com.solesasia.portfolio.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long persona_id;

    public Experiencia() {
    }

    public Experiencia(Long id, String puestoExpe, String periodoExpe, String organismoExpe, String descripcionExpe, String urlLogoExpe, Long persona_id) {
        this.id = id;
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.organismoExpe = organismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
        this.persona_id = persona_id;
    }

}
