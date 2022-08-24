
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadBlanda;


public interface IHabilidadBlandaService {
    
    public void crearHabBlanda(HabilidadBlanda habBlanda);
    
    public boolean editarHabBlanda(Long id, HabilidadBlanda habBlanda);
    
    public void borrarHabBlanda(Long id);
    
}
