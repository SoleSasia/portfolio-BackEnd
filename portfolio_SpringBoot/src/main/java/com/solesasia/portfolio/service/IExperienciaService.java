
package com.solesasia.portfolio.service;


import com.solesasia.portfolio.dto.ExpeDto;


public interface IExperienciaService {
    
    public void crearExperiencia(ExpeDto expe);
       
    public boolean editarExperiencia(Long id, ExpeDto expe);
    
    public void borrarExperiencia(Long id);
}
