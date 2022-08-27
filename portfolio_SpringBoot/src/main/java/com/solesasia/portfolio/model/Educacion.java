
package com.solesasia.portfolio.model;

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
public class Educacion implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;
    private Long personaId;

    public Educacion() {
    }

    public Educacion(String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu, Long personaId) {
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
        this.personaId = personaId;
    }

}
