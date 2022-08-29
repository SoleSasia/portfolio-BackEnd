package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ExpeDto {
    
    private Long id;
    private Long personaId;
    private String puestoExpe;
    private String periodoExpe;
    private String organismoExpe;
    private String descripcionExpe;
    private String urlLogoExpe;

    public ExpeDto() {
    }

    public ExpeDto(Long id, Long personaId, String puestoExpe, String periodoExpe, String organismoExpe, String descripcionExpe, String urlLogoExpe) {
        this.id = id;
        this.personaId = personaId;
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.organismoExpe = organismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
    }
    
}
