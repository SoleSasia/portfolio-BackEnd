package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.model.Education;
import com.solesasia.portfolio.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solesasia.portfolio.repository.EducationRepository;
import com.solesasia.portfolio.repository.PersonRepository;

//esta clase implementa la interfaz donde están declarados los métodos CRUD
@Service
public class EducationService implements IEducationService {

    /* Inyecto el repositorio 
    La interfaz en la capa repository será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired public EducationRepository repoEducation;
    @Autowired public PersonRepository repoPerson;

    //Create - Alta
    @Override
    public void createEducation(EducationDto educationDto) {
        Person person = repoPerson.findById(educationDto.getPersonId()).orElse(null);
        Education newEducation = new Education(person, educationDto.getTitle(), educationDto.getPeriod(), educationDto.getInstitution(), educationDto.getDescription(), educationDto.getLogoUrl());
        repoEducation.save(newEducation);
    }

    //Update - Actualizar
    @Override
    public boolean updateEducation(Long id, EducationDto educationDto) {
        if (!repoEducation.existsById(id)) {
            return false;
        } else {
            Education updatedEducation = repoEducation.findById(id).orElse(null);
            updatedEducation.setPerson(repoPerson.findById(educationDto.getPersonId()).orElse(null));
            updatedEducation.setTitle(educationDto.getTitle());
            updatedEducation.setPeriod(educationDto.getPeriod());
            updatedEducation.setInstitution(educationDto.getInstitution());
            updatedEducation.setDescription(educationDto.getDescription());
            updatedEducation.setLogoUrl(educationDto.getLogoUrl());
            repoEducation.save(updatedEducation);
            return true;
        }
    }

    //Delete - Baja
    @Override
    public void deleteEducation(Long id) {
        repoEducation.deleteById(id);
    }
}
