
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.model.SoftSill;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.repository.SoftSkillRepository;
import com.solesasia.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadBlandaService implements IHabilidadBlandaService {

    @Autowired public SoftSkillRepository repoHabBlanda;
    @Autowired public PersonRepository repoPerso;

    @Override
    public void crearHabBlanda(HabBlandaDto habBlanda) {
        Person perso = repoPerso.findById(habBlanda.getPersonaId()).orElse(null);
        SoftSill nuevaHabBlanda = new SoftSill(perso, habBlanda.getNombreHabilidad(), habBlanda.getUrlIcono());
        repoHabBlanda.save(nuevaHabBlanda);
    }

    @Override
    public boolean editarHabBlanda(Long id, HabBlandaDto habBlanda) {
        if (!repoHabBlanda.existsById(id)) {
            return false;
        } else {
            SoftSill habBlandaEditada = repoHabBlanda.findById(id).orElse(null);
            habBlandaEditada.setPerson(repoPerso.findById(habBlanda.getPersonaId()).orElse(null));
            habBlandaEditada.setSkillName(habBlanda.getNombreHabilidad());
            habBlandaEditada.setIconUrl(habBlanda.getUrlIcono());
            repoHabBlanda.save(habBlandaEditada);
            return true;
        }
    }

    @Override
    public void borrarHabBlanda(Long id) {
        repoHabBlanda.deleteById(id);
    }

    
}