package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Persona {
    
    @Id
    private Long id;
    private String nombre;
    private String ocupacion;
    private String bannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String descripcion;
    private String imgUrl;
    
    //@JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educaciones;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<Experiencia> experiencias;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<HabilidadTecnica> habTecnicas;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<HabilidadBlanda> habBlandas;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<Proyecto> proyectos;
    
    

    public Persona() {
    }

    public Persona(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, List<Educacion> educaciones) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.educaciones = educaciones;
    }

    

}