
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public void crearProyecto(Proyecto proyecto);
    
    //public List<Proyecto> listarProyectos();
    
    public String editarProyecto(Long id, Proyecto proyecto);
    
    public void borrarProyecto(Long id);
    
}
