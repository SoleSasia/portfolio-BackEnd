package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.hardSkillDto;

public interface IHabilidadTecnicaService {
    
    public void crearHabTecnica(hardSkillDto habTecnica);
    
    public boolean editarHabTecnica(Long id, hardSkillDto habTecnica);
    
    public void borrarHabTecnica(Long id);
    
}
