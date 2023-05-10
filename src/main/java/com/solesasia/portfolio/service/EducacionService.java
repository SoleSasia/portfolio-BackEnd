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
public class EducacionService implements IEducacionService {

    /* Inyecto el repositorio 
    La interfaz en la capa repository será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired public EducationRepository repoEdu;
    @Autowired public PersonRepository repoPerso;

    //Create - Alta
    @Override
    public void crearEducacion(EducationDto edu) {
        Person perso = repoPerso.findById(edu.getPersonId()).orElse(null);
        Education nuevaEdu = new Education(perso, edu.getTitle(), edu.getPeriod(), edu.getInstitution(), edu.getDescription(), edu.getLogoUrl());
        repoEdu.save(nuevaEdu);
    }

    //Update - Actualizar
    @Override
    public boolean editarEducacion(Long id, EducationDto edu) {
        if (!repoEdu.existsById(id)) {
            return false;
        } else {
            Education eduEditada = repoEdu.findById(id).orElse(null);
            eduEditada.setPerson(repoPerso.findById(edu.getPersonId()).orElse(null));
            eduEditada.setTitle(edu.getTitle());
            eduEditada.setPeriod(edu.getPeriod());
            eduEditada.setInstitution(edu.getInstitution());
            eduEditada.setDescription(edu.getDescription());
            eduEditada.setLogoUrl(edu.getLogoUrl());
            repoEdu.save(eduEditada);
            return true;
        }
    }

    //Delete - Baja
    @Override
    public void borrarEducacion(Long id) {
        repoEdu.deleteById(id);
    }
   
}
