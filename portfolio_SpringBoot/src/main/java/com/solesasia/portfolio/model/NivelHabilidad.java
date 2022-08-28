package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class NivelHabilidad implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreNivel;
    
    @JsonIgnore
    @OneToMany(mappedBy = "nivel")
    private List<HabilidadTecnica> habTecnicas;
 

    public NivelHabilidad() {
    }

    public NivelHabilidad(Long id, String nombreNivel) {
        this.id = id;
        this.nombreNivel = nombreNivel;
    }

    

}
