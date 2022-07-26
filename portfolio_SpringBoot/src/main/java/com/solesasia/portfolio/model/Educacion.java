
package com.solesasia.portfolio.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Educacion implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String nombreInstitucion;
    private String fechaInicio;
    private String fechaFin;
    private String urlLogo;
    private String descripcion;

    public Educacion() {
    }

    public Educacion(String titulo, String nombreInstitucion, String fechaInicio, String fechaFin, String urlLogo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.descripcion = descripcion;
    }

   
    
    
    
}
