
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
public class Educacion implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    
   

    public Educacion() {
    }

    public Educacion(String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu, Persona persona, Long idPerso) {
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
        this.persona = persona;
    }

    

}
