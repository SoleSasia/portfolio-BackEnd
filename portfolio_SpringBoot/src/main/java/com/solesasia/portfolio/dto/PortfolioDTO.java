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
public class PortfolioDTO {
    
    private Persona persona;
    private List<Educacion> listaEducacion;
    private List<Experiencia> listaExperiencia;
    private List<HabilidadTecnica> listaHabilidadTecnica;
    private List<HabilidadBlanda> listaHabilidadBlanda;
    private List<Proyecto> listaProyecto;

    public PortfolioDTO() {
    }

    public PortfolioDTO(Persona persona, List<Educacion> listaEducacion, List<Experiencia> listaExperiencia, List<HabilidadTecnica> listaHabilidadTecnica, List<HabilidadBlanda> listaHabilidadBlanda, List<Proyecto> listaProyecto) {
        this.persona = persona;
        this.listaEducacion = listaEducacion;
        this.listaExperiencia = listaExperiencia;
        this.listaHabilidadTecnica = listaHabilidadTecnica;
        this.listaHabilidadBlanda = listaHabilidadBlanda;
        this.listaProyecto = listaProyecto;
    }
    
}
