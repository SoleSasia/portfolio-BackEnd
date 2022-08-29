package com.solesasia.portfolio.dto;

import java.util.List;
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
    private List<EduDto> educaciones;   
    private List<ExpeDto> experiencias;   
    private List<HabTecnicaDto> habTecnicas;   
    private List<HabBlandaDto> habBlandas;
    private List<ProyectoDto> proyectos;

    public PortfolioDto() {
    }

    public PortfolioDto(Long id, String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, List<EduDto> educaciones, List<ExpeDto> experiencias, List<HabTecnicaDto> habTecnicas, List<HabBlandaDto> habBlandas, List<ProyectoDto> proyectos) {
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
