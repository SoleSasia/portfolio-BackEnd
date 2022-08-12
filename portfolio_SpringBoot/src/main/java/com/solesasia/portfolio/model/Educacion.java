
package com.solesasia.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Educacion {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String tituloEdu;
    private String periodoEdu;
    private String nombreInstituEdu;
    private String descripcionEdu;
    private String urlLogoEdu;

    public Educacion() {
    }

    public Educacion(Long id, String tituloEdu, String periodoEdu, String nombreInstituEdu, String descripcionEdu, String urlLogoEdu) {
        this.id = id;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.nombreInstituEdu = nombreInstituEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
    }
    
}
