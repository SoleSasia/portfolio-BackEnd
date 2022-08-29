
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.NivelHabilidad;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.repository.HabilidadTecnicaRepository;
import com.solesasia.portfolio.repository.NivelHabilidadRepository;
import com.solesasia.portfolio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadTecnicaService implements IHabilidadTecnicaService {

    @Autowired public HabilidadTecnicaRepository repoHabTecnica;
    @Autowired public PersonaRepository repoPerso;
    @Autowired public NivelHabilidadRepository repoNivel;

    @Override
    public void crearHabTecnica(HabTecnicaDto habTecnica) {
        Persona perso = repoPerso.findById(habTecnica.getPersonaId()).orElse(null);
        NivelHabilidad nivelHab = repoNivel.findById(habTecnica.getNivelId()).orElse(null);
        HabilidadTecnica nuevaHabTecnica = new HabilidadTecnica(perso, nivelHab, habTecnica.getNombreHabilidad(), habTecnica.getUrlIcono());
        repoHabTecnica.save(nuevaHabTecnica);
    }             
                
    @Override
    public boolean editarHabTecnica(Long id, HabTecnicaDto habTecnica) {
        if (!repoHabTecnica.existsById(id)) {
            return false;
        } else {
            HabilidadTecnica HabTecnicaEditada = repoHabTecnica.findById(id).orElse(null);
            HabTecnicaEditada.setPersona(repoPerso.findById(habTecnica.getPersonaId()).orElse(null));
            HabTecnicaEditada.setNivel(repoNivel.findById(habTecnica.getNivelId()).orElse(null));
            HabTecnicaEditada.setNombreHabilidad(habTecnica.getNombreHabilidad());
            HabTecnicaEditada.setUrlIcono(habTecnica.getUrlIcono());
            repoHabTecnica.save(HabTecnicaEditada);
            return true;
        }
    }

    @Override
    public void borrarHabTecnica(Long id) {
        repoHabTecnica.deleteById(id);
    }
    
    }
