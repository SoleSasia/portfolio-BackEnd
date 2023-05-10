
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.model.HardSkill;
import com.solesasia.portfolio.model.SkillLevel;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.repository.HardSkillRepository;
import com.solesasia.portfolio.repository.SkillLevelRepository;
import com.solesasia.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadTecnicaService implements IHabilidadTecnicaService {

    @Autowired public HardSkillRepository repoHabTecnica;
    @Autowired public PersonRepository repoPerso;
    @Autowired public SkillLevelRepository repoNivel;

    @Override
    public void crearHabTecnica(HabTecnicaDto habTecnica) {
        Person perso = repoPerso.findById(habTecnica.getPersonaId()).orElse(null);
        SkillLevel nivelHab = repoNivel.findById(habTecnica.getNivelId()).orElse(null);
        HardSkill nuevaHabTecnica = new HardSkill(perso, nivelHab, habTecnica.getNombreHabilidad(), habTecnica.getUrlIcono());
        repoHabTecnica.save(nuevaHabTecnica);
    }             
                
    @Override
    public boolean editarHabTecnica(Long id, HabTecnicaDto habTecnica) {
        if (!repoHabTecnica.existsById(id)) {
            return false;
        } else {
            HardSkill HabTecnicaEditada = repoHabTecnica.findById(id).orElse(null);
            HabTecnicaEditada.setPerson(repoPerso.findById(habTecnica.getPersonaId()).orElse(null));
            HabTecnicaEditada.setLevel(repoNivel.findById(habTecnica.getNivelId()).orElse(null));
            HabTecnicaEditada.setSkillName(habTecnica.getNombreHabilidad());
            HabTecnicaEditada.setIconUrl(habTecnica.getUrlIcono());
            repoHabTecnica.save(HabTecnicaEditada);
            return true;
        }
    }

    @Override
    public void borrarHabTecnica(Long id) {
        repoHabTecnica.deleteById(id);
    }
    
    }
