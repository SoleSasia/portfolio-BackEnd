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
public class HabilidadBlanda implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreHabilidad;
    private String urlIcono;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    //private Long personaId;

    public HabilidadBlanda() {
    }

    public HabilidadBlanda(String nombreHabilidad, String urlIcono) {
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
        
    }
    
}
