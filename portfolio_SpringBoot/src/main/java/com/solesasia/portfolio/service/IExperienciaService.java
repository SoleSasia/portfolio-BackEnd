
package com.solesasia.portfolio.service;


import com.solesasia.portfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public void crearExperiencia(Experiencia expe);
       
    public boolean editarExperiencia(Long id, Experiencia expe);
    
    public void borrarExperiencia(Long id);
}
