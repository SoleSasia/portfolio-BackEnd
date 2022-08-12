
package com.solesasia.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Experiencia {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String puestoExpe;
    private String periodoExpe;
    private String nombreOrganismoExpe;
    private String descripcionExpe;
    private String urlLogoExpe;

    public Experiencia() {
    }

    public Experiencia(Long id, String puestoExpe, String periodoExpe, String nombreOrganismoExpe, String descripcionExpe, String urlLogoExpe) {
        this.id = id;
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.nombreOrganismoExpe = nombreOrganismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
    }
    
}
