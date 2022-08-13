
package com.solesasia.portfolio.service;


import com.solesasia.portfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public void crearExperiencia(Experiencia expe);
    
    public List<Experiencia> listarExperiencias();
    
    public String editarExperiencia(Long id, Experiencia expe);
    
    public void borrarExperiencia(Long id);
}
