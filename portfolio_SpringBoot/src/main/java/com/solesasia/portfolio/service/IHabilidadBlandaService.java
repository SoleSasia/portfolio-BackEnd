
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabBlandaDto;


public interface IHabilidadBlandaService {
    
    public void crearHabBlanda(HabBlandaDto habBlanda);
    
    public boolean editarHabBlanda(Long id, HabBlandaDto habBlanda);
    
    public void borrarHabBlanda(Long id);
    
}
