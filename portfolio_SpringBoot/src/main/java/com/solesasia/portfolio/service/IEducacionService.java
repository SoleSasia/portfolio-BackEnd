package com.solesasia.portfolio.service;


import com.solesasia.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {

//declaro los métodos (CRUD) sin implementar, eso será función de ServiceEducacion
    public void crearEducacion(Educacion edu);
    
    public List<Educacion> listarEducaciones();
    
    public String editarEducacion(Long id, Educacion edu);
    
    public void borrarEducacion(Long id);
   
}
