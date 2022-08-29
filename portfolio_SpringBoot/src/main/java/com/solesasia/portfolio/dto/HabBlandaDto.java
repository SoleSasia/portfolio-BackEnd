package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class HabBlandaDto {
    
    private Long id;
    private Long personaId;
    private String nombreHabilidad;
    private String urlIcono;

    public HabBlandaDto() {
    }

    public HabBlandaDto(Long id, Long personaId, String nombreHabilidad, String urlIcono) {
        this.id = id;
        this.personaId = personaId;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }
 
}
