package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabTecnicaDto;

public interface IHabilidadTecnicaService {
    
    public void crearHabTecnica(HabTecnicaDto habTecnica);
    
    public boolean editarHabTecnica(Long id, HabTecnicaDto habTecnica);
    
    public void borrarHabTecnica(Long id);
    
}
