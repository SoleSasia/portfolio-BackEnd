package com.solesasia.portfolio.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class PortfolioDto {
    
    private PersoDto persona;    
    private List<EduDto> educaciones;   
    private List<ExpeDto> experiencias;   
    private List<HabTecnicaDto> habTecnicas;   
    private List<HabBlandaDto> habBlandas;
    private List<ProyeDto> proyectos;

    public PortfolioDto() {
    }

    public PortfolioDto(PersoDto persona, List<EduDto> educaciones, List<ExpeDto> experiencias, List<HabTecnicaDto> habTecnicas, List<HabBlandaDto> habBlandas, List<ProyeDto> proyectos) {
        this.persona = persona;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.habTecnicas = habTecnicas;
        this.habBlandas = habBlandas;
        this.proyectos = proyectos;
    }
 
}
