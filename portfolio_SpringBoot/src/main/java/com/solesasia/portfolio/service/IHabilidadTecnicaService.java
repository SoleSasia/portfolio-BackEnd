
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadTecnica;


public interface IHabilidadTecnicaService {
    
    public void crearHabTecnica(HabilidadTecnica habTecnica);
    
    public boolean editarHabTecnica(Long id, HabilidadTecnica habTecnica);
    
    public void borrarHabTecnica(Long id);
    
}
