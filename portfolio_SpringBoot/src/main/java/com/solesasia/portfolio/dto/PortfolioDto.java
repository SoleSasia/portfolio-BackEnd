package com.solesasia.portfolio.dto;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
import java.util.List;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class PortfolioDto {
    
    private Long id;
    private String nombre;
    private String ocupacion;
    private String bannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String descripcion;
    private String imgUrl;    
    private List<Educacion> educaciones;   
    private List<Experiencia> experiencias;   
    private List<HabilidadTecnica> habTecnicas;   
    private List<HabilidadBlanda> habBlandas;
    private List<Proyecto> proyectos;

    public PortfolioDto() {
    }

    public PortfolioDto(Long id, String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, List<Educacion> educaciones, List<Experiencia> experiencias, List<HabilidadTecnica> habTecnicas, List<HabilidadBlanda> habBlandas, List<Proyecto> proyectos) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.habTecnicas = habTecnicas;
        this.habBlandas = habBlandas;
        this.proyectos = proyectos;
    }
    
}
