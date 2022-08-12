package com.solesasia.portfolio.dto;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Persona;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PortfolioDto {
    
    private Persona persona;
    private List<Educacion> listaEducacion;
    private List<Experiencia> listaExperiencia;
    private List<HabilidadTecnica> listaHabilidadTecnica;
    private List<HabilidadBlanda> listaHabilidadBlanda;
    private List<Proyectoa> listaProyecto;
    
}
