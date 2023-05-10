package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EducationDto;


public interface IEducacionService {

//declaro los métodos (CRUD) sin implementar, eso será función de ServiceEducacion
    public void crearEducacion(EducationDto edu);
    
    public boolean editarEducacion(Long id, EducationDto edu);
    
    public void borrarEducacion(Long id);
}
