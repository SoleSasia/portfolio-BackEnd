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
public class HabilidadTecnica implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreHabilidad;
    private String urlIcono;
    private Long personaId;
    private Long nivelId;

    public HabilidadTecnica() {
    }

    public HabilidadTecnica(Long id, String nombreHabilidad, String urlIcono, Long personaId, Long nivelId) {
        this.id = id;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
        this.personaId = personaId;
        this.nivelId = nivelId;
    }
    
}
