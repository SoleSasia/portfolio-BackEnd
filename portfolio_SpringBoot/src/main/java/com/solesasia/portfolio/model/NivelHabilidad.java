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
public class NivelHabilidad implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nivelHabilidad;

    public NivelHabilidad() {
    }

    public NivelHabilidad(Long id, String nivelHabilidad) {
        this.id = id;
        this.nivelHabilidad = nivelHabilidad;
    }

}
