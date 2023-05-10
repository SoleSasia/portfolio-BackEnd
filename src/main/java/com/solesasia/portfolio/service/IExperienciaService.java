
package com.solesasia.portfolio.service;


import com.solesasia.portfolio.dto.ExperienceDto;


public interface IExperienciaService {
    
    public void crearExperiencia(ExperienceDto expe);
       
    public boolean editarExperiencia(Long id, ExperienceDto expe);
    
    public void borrarExperiencia(Long id);
}
