package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;
import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solesasia.portfolio.repository.EducacionRepository;
import com.solesasia.portfolio.repository.PersonaRepository;


//esta clase implementa la interfaz donde están declarados los métodos CRUD
@Service
public class EducacionService implements IEducacionService {

    /* Inyecto el repositorio 
    La interfaz en la capa repository será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired public EducacionRepository repoEdu;
    @Autowired public PersonaRepository repoPerso;

    //Create - Alta
    @Override
    public void crearEducacion(EduDto edu) {
        Persona perso = repoPerso.findById(edu.getPersonaId()).orElse(null);
        Educacion nuevaEdu = new Educacion(perso, edu.getTituloEdu(), edu.getPeriodoEdu(), edu.getInstitucionEdu(), edu.getDescripcionEdu(), edu.getUrlLogoEdu());
        repoEdu.save(nuevaEdu);
    }

    //Update - Actualizar
    @Override
    public boolean editarEducacion(Long id, EduDto edu) {
        if (!repoEdu.existsById(id)) {
            return false;
        } else {
            Educacion eduEditada = repoEdu.findById(id).orElse(null);
            eduEditada.setPersona(repoPerso.findById(edu.getPersonaId()).orElse(null));
            eduEditada.setTituloEdu(edu.getTituloEdu());
            eduEditada.setPeriodoEdu(edu.getPeriodoEdu());
            eduEditada.setInstitucionEdu(edu.getInstitucionEdu());
            eduEditada.setDescripcionEdu(edu.getDescripcionEdu());
            eduEditada.setUrlLogoEdu(edu.getUrlLogoEdu());
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
