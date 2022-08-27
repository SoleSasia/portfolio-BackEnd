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
public class Proyecto implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;
    private String liveUrl;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    //private Long personaId;

    public Proyecto() {
    }

    public Proyecto(String nombreProye, String descripcionProye, String imgUrl, String repoUrl, String liveUrl) {
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
       
    }
    
}
