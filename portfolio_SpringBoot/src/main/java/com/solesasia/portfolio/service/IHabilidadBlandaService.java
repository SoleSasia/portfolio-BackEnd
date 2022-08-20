
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadBlanda;
import java.util.List;


public interface IHabilidadBlandaService {
    
    public void crearHabBlanda(HabilidadBlanda habBlanda);
    
    //public List<HabilidadBlanda> listarHabBlandas();
    
    public String editarHabBlanda(Long id, HabilidadBlanda habBlanda);
    
    public void borrarHabBlanda(Long id);
    
}
