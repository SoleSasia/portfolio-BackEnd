package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProyeDto {
    
    private Long id;
    private Long personaId;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;
    private String liveUrl;

    public ProyeDto() {
    }

    public ProyeDto(Long id, Long personaId, String nombreProye, String descripcionProye, String imgUrl, String repoUrl, String liveUrl) {
        this.id = id;
        this.personaId = personaId;
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
    }
    
}
