
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.repository.HabilidadBlandaRepository;
import com.solesasia.portfolio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadBlandaService implements IHabilidadBlandaService {

    @Autowired public HabilidadBlandaRepository repoHabBlanda;
    @Autowired public PersonaRepository repoPerso;

    @Override
    public void crearHabBlanda(HabBlandaDto habBlanda) {
        Persona perso = repoPerso.findById(habBlanda.getPersonaId()).orElse(null);
        HabilidadBlanda nuevaHabBlanda = new HabilidadBlanda(perso, habBlanda.getNombreHabilidad(), habBlanda.getUrlIcono());
        repoHabBlanda.save(nuevaHabBlanda);
    }

    @Override
    public boolean editarHabBlanda(Long id, HabBlandaDto habBlanda) {
        if (!repoHabBlanda.existsById(id)) {
            return false;
        } else {
            HabilidadBlanda habBlandaEditada = repoHabBlanda.findById(id).orElse(null);
            habBlandaEditada.setPersona(repoPerso.findById(habBlanda.getPersonaId()).orElse(null));
            habBlandaEditada.setNombreHabilidad(habBlanda.getNombreHabilidad());
            habBlandaEditada.setUrlIcono(habBlanda.getUrlIcono());
            repoHabBlanda.save(habBlandaEditada);
            return true;
        }
    }

    @Override
    public void borrarHabBlanda(Long id) {
        repoHabBlanda.deleteById(id);
    }

    
}