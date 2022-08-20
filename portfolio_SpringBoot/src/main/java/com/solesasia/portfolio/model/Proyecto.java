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
public class Proyecto implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;
    private String liveUrl;
    private Long personaId;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProye, String descripcionProye, String imgUrl, String repoUrl, String liveUrl, Long personaId) {
        this.id = id;
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
        this.personaId = personaId;
    }
    
}
