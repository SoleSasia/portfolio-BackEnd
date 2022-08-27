package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
   
    //mapear para que sea unico??
    private String username;
    private String password;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personaId")
    private List<Educacion> educaciones;
    

    public Persona() {
    }

    public Persona(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, String username, String password, List<Educacion> educaciones) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.username = username;
        this.password = password;
        this.educaciones = educaciones;
    }

    

    

    

    

}