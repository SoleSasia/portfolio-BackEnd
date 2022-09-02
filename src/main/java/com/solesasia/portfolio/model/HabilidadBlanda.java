package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class HabilidadBlanda implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    private String nombreHabilidad;
    private String urlIcono;
    
   
    public HabilidadBlanda() {
    }

    public HabilidadBlanda(Persona persona, String nombreHabilidad, String urlIcono) {
        this.persona = persona;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }

    
    
}
