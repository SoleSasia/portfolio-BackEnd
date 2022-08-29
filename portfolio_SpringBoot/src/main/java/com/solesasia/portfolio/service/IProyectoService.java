
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ProyeDto;


public interface IProyectoService {
    
    public void crearProyecto(ProyeDto proyecto);
    
    public boolean editarProyecto(Long id, ProyeDto proyecto);
    
    public void borrarProyecto(Long id);
    
}
