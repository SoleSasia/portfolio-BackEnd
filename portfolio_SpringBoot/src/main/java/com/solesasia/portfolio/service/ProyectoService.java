
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ProyeDto;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
import com.solesasia.portfolio.repository.PersonaRepository;
import com.solesasia.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired public ProyectoRepository repoProye;
    @Autowired public PersonaRepository repoPerso;
    
    @Override
    public void crearProyecto(ProyeDto proye) {
        Persona perso = repoPerso.findById(proye.getPersonaId()).orElse(null);
        Proyecto nuevoProye = new Proyecto(perso, proye.getNombreProye(), proye.getDescripcionProye(), proye.getImgUrl(), proye.getRepoUrl(), proye.getLiveUrl());
        repoProye.save(nuevoProye);
    }

    @Override
    public boolean editarProyecto(Long id, ProyeDto proye) {
        if (!repoProye.existsById(id)) {
            return false;
        } else {
            Proyecto proyeEditado = repoProye.findById(id).orElse(null);
            proyeEditado.setPersona(repoPerso.findById(proye.getPersonaId()).orElse(null));
            proyeEditado.setNombreProye(proye.getNombreProye());
            proyeEditado.setDescripcionProye(proye.getDescripcionProye());
            proyeEditado.setImgUrl(proye.getImgUrl());
            proyeEditado.setRepoUrl(proye.getRepoUrl());
            proyeEditado.setLiveUrl(proye.getLiveUrl());
            repoProye.save(proyeEditado);
            return true;
        }
    }

    @Override
    public void borrarProyecto(Long id) {
        repoProye.deleteById(id);
    }

    
}
