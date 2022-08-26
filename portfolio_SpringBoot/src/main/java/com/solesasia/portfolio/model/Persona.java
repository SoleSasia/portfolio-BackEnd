package com.solesasia.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ocupacion;
    private String bannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String descripcion;
    private String imgUrl;
    
    private String username;
    private String password;
    
    //@OneToOne
    //@MapsId
    //@JoinColumn(name="usuario_id")
    //private Usuario usuario;

    public Persona() {
    }

    public Persona(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String descripcion, String imgUrl, String username, String password) {
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
    }

    

    

}