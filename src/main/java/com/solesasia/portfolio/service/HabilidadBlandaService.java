
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.SoftSkillDto;
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
    public void crearHabBlanda(SoftSkillDto habBlanda) {
        Person perso = repoPerso.findById(habBlanda.getPersonId()).orElse(null);
        SoftSill nuevaHabBlanda = new SoftSill(perso, habBlanda.getSkillName(), habBlanda.getIconUrl());
        repoHabBlanda.save(nuevaHabBlanda);
    }

    @Override
    public boolean editarHabBlanda(Long id, SoftSkillDto habBlanda) {
        if (!repoHabBlanda.existsById(id)) {
            return false;
        } else {
            SoftSill habBlandaEditada = repoHabBlanda.findById(id).orElse(null);
            habBlandaEditada.setPerson(repoPerso.findById(habBlanda.getPersonId()).orElse(null));
            habBlandaEditada.setSkillName(habBlanda.getSkillName());
            habBlandaEditada.setIconUrl(habBlanda.getIconUrl());
            repoHabBlanda.save(habBlandaEditada);
            return true;
        }
    }

    @Override
    public void borrarHabBlanda(Long id) {
        repoHabBlanda.deleteById(id);
    }

    
}