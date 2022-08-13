
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadTecnica;
import java.util.List;


public interface IHabilidadTecnicaService {
    
    public void crearHabTecnica(HabilidadTecnica habTecnica);
    
    public List<HabilidadTecnica> listarHabTecnicas();
    
    public String editarHabTecnica(Long id, HabilidadTecnica habTecnica);
    
    public void borrarHabTecnica(Long id);
    
}
