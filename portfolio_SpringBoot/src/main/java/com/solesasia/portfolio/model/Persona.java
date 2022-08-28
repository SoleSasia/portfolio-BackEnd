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
    //@JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;
    //@JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<HabilidadTecnica> habTecnicas;
    //@JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<HabilidadBlanda> habBlandas;
    //@JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    

    public Persona() {
    }

    //constructor para ediciones de persona
    public Persona(Long id, String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }

    
    
    public Persona(Long id, String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, List<Educacion> educaciones, List<Experiencia> experiencias, List<HabilidadTecnica> habTecnicas, List<HabilidadBlanda> habBlandas, List<Proyecto> proyectos) {
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