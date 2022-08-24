
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Proyecto;



public interface IProyectoService {
    
    public void crearProyecto(Proyecto proyecto);
    
    public boolean editarProyecto(Long id, Proyecto proyecto);
    
    public void borrarProyecto(Long id);
    
}
