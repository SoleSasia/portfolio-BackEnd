package com.solesasia.portfolio.dto;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
import java.util.List;
import lombok.Data;


@Data
public class PortfolioDto {
    
    private Persona persona;
    private List<Educacion> educaciones;
    private List<Experiencia> experiencias;
    private List<HabilidadTecnica> habilidadesTecnicas;
    private List<HabilidadBlanda> habilidadesBlandas;
    private List<Proyecto> proyectos;

    public PortfolioDto() {
    }

    public PortfolioDto(Persona persona, List<Educacion> educaciones, List<Experiencia> experiencias, List<HabilidadTecnica> habilidadesTecnicas, List<HabilidadBlanda> habilidadesBlandas, List<Proyecto> proyectos) {
        this.persona = persona;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.habilidadesBlandas = habilidadesBlandas;
        this.proyectos = proyectos;
    }
    
}
