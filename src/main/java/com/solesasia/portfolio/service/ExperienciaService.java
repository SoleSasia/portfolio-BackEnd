
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ExpeDto;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.repository.ExperienciaRepository;
import com.solesasia.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired public ExperienciaRepository repoExpe;
    @Autowired public PersonaRepository repoPerso;

    
    @Override
    public void crearExperiencia(ExpeDto expe) {
        Persona perso = repoPerso.findById(expe.getPersonaId()).orElse(null);
        Experiencia nuevaExpe = new Experiencia(perso, expe.getPuestoExpe(), expe.getPeriodoExpe(), expe.getOrganismoExpe(), expe.getDescripcionExpe(), expe.getUrlLogoExpe());
        repoExpe.save(nuevaExpe);
    }

    @Override
    public boolean editarExperiencia(Long id, ExpeDto expe) {
        if (!repoExpe.existsById(id)) {
            return false;
        } else {
            Experiencia expeEditada = repoExpe.findById(id).orElse(null);
            expeEditada.setPersona(repoPerso.findById(expe.getPersonaId()).orElse(null));
            expeEditada.setPuestoExpe(expe.getPuestoExpe());
            expeEditada.setPeriodoExpe(expe.getPeriodoExpe());
            expeEditada.setOrganismoExpe(expe.getOrganismoExpe());
            expeEditada.setDescripcionExpe(expe.getDescripcionExpe());
            expeEditada.setUrlLogoExpe(expe.getUrlLogoExpe());
            repoExpe.save(expeEditada);
            return true;
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}
