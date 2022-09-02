package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;


public interface IEducacionService {

//declaro los métodos (CRUD) sin implementar, eso será función de ServiceEducacion
    public void crearEducacion(EduDto edu);
    
    public boolean editarEducacion(Long id, EduDto edu);
    
    public void borrarEducacion(Long id);
}
