package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class HabTecnicaDto {
    
    private Long id;
    private Long personaId;
    private Long nivelId;
    private String nombreHabilidad;
    private String urlIcono;

    public HabTecnicaDto() {
    }

    public HabTecnicaDto(Long id, Long personaId, Long nivelId, String nombreHabilidad, String urlIcono) {
        this.id = id;
        this.personaId = personaId;
        this.nivelId = nivelId;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }

    
    
}
