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
public class HabilidadTecnica implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreHabilidad;
    private String urlIcono;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    //private Long personaId;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id")
    private NivelHabilidad nivel;
    

    public HabilidadTecnica() {
    }

    public HabilidadTecnica(String nombreHabilidad, String urlIcono, NivelHabilidad nivel) {
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }

    

}
