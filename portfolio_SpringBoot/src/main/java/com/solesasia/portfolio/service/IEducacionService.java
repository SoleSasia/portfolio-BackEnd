package com.solesasia.portfolio.service;

//declaro los métodos (CRUD) y NO los implemento, eso será función de ServiceEducacion

import com.solesasia.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
 
    public List<Educacion> listarEducaciones();
    
    public void crearEducacion(Educacion edu);
    
    public void editarEducacion(Educacion edu);
    
    public void borrarEducacion(Long id);
    
    public Educacion buscarEducacion(Long id);
    
}
