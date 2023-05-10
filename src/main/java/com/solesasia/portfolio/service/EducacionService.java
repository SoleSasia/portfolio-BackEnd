package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;
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
    public void crearEducacion(EduDto edu) {
        Person perso = repoPerso.findById(edu.getPersonaId()).orElse(null);
        Education nuevaEdu = new Education(perso, edu.getTituloEdu(), edu.getPeriodoEdu(), edu.getInstitucionEdu(), edu.getDescripcionEdu(), edu.getUrlLogoEdu());
        repoEdu.save(nuevaEdu);
    }

    //Update - Actualizar
    @Override
    public boolean editarEducacion(Long id, EduDto edu) {
        if (!repoEdu.existsById(id)) {
            return false;
        } else {
            Education eduEditada = repoEdu.findById(id).orElse(null);
            eduEditada.setPerson(repoPerso.findById(edu.getPersonaId()).orElse(null));
            eduEditada.setTitle(edu.getTituloEdu());
            eduEditada.setPeriod(edu.getPeriodoEdu());
            eduEditada.setInstitution(edu.getInstitucionEdu());
            eduEditada.setDescription(edu.getDescripcionEdu());
            eduEditada.setLogoUrl(edu.getUrlLogoEdu());
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
