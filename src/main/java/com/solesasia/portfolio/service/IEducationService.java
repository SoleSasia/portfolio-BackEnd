package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EducationDto;

public interface IEducationService {

//declaro los métodos (CRUD) sin implementar, eso será función de ServiceEducation
    public void createEducation(EducationDto educationDto);
    
    public boolean updateEducation(Long id, EducationDto educationDto);
    
    public void deleteEducation(Long id);
}
