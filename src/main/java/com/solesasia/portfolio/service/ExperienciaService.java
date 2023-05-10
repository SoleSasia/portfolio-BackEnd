
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ExperienceDto;
import com.solesasia.portfolio.model.Experience;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.repository.ExperienceRepository;
import com.solesasia.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired public ExperienceRepository repoExpe;
    @Autowired public PersonRepository repoPerso;

    
    @Override
    public void crearExperiencia(ExperienceDto expe) {
        Person perso = repoPerso.findById(expe.getPersonId()).orElse(null);
        Experience nuevaExpe = new Experience(perso, expe.getPosition(), expe.getPeriod(), expe.getCompany(), expe.getDescription(), expe.getLogoUrl());
        repoExpe.save(nuevaExpe);
    }

    @Override
    public boolean editarExperiencia(Long id, ExperienceDto expe) {
        if (!repoExpe.existsById(id)) {
            return false;
        } else {
            Experience expeEditada = repoExpe.findById(id).orElse(null);
            expeEditada.setPerson(repoPerso.findById(expe.getPersonId()).orElse(null));
            expeEditada.setPosition(expe.getPosition());
            expeEditada.setPeriod(expe.getPeriod());
            expeEditada.setCompany(expe.getCompany());
            expeEditada.setDescription(expe.getDescription());
            expeEditada.setLogoUrl(expe.getLogoUrl());
            repoExpe.save(expeEditada);
            return true;
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}
