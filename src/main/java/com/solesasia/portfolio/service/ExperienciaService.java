
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ExpeDto;
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
    public void crearExperiencia(ExpeDto expe) {
        Person perso = repoPerso.findById(expe.getPersonaId()).orElse(null);
        Experience nuevaExpe = new Experience(perso, expe.getPuestoExpe(), expe.getPeriodoExpe(), expe.getOrganismoExpe(), expe.getDescripcionExpe(), expe.getUrlLogoExpe());
        repoExpe.save(nuevaExpe);
    }

    @Override
    public boolean editarExperiencia(Long id, ExpeDto expe) {
        if (!repoExpe.existsById(id)) {
            return false;
        } else {
            Experience expeEditada = repoExpe.findById(id).orElse(null);
            expeEditada.setPerson(repoPerso.findById(expe.getPersonaId()).orElse(null));
            expeEditada.setPosition(expe.getPuestoExpe());
            expeEditada.setPeriod(expe.getPeriodoExpe());
            expeEditada.setCompany(expe.getOrganismoExpe());
            expeEditada.setDescription(expe.getDescripcionExpe());
            expeEditada.setLogoUrl(expe.getUrlLogoExpe());
            repoExpe.save(expeEditada);
            return true;
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}
