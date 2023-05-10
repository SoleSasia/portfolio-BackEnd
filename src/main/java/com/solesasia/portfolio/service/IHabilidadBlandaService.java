
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.SoftSkillDto;


public interface IHabilidadBlandaService {
    
    public void crearHabBlanda(SoftSkillDto habBlanda);
    
    public boolean editarHabBlanda(Long id, SoftSkillDto habBlanda);
    
    public void borrarHabBlanda(Long id);
    
}
