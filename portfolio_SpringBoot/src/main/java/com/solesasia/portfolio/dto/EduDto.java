package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EduDto {
    
    private Long id;
    private Long personaId;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;

    public EduDto() {
    }

    public EduDto(Long id, Long personaId, String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu) {
        this.id = id;
        this.personaId = personaId;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
    }
    
    
}
