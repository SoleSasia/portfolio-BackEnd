
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ProyeDto;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.model.Project;
import com.solesasia.portfolio.repository.PersonRepository;
import com.solesasia.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired public ProjectRepository repoProye;
    @Autowired public PersonRepository repoPerso;
    
    @Override
    public void crearProyecto(ProyeDto proye) {
        Person perso = repoPerso.findById(proye.getPersonaId()).orElse(null);
        Project nuevoProye = new Project(perso, proye.getNombreProye(), proye.getDescripcionProye(), proye.getImgUrl(), proye.getRepoUrl(), proye.getLiveUrl());
        repoProye.save(nuevoProye);
    }

    @Override
    public boolean editarProyecto(Long id, ProyeDto proye) {
        if (!repoProye.existsById(id)) {
            return false;
        } else {
            Project proyeEditado = repoProye.findById(id).orElse(null);
            proyeEditado.setPerson(repoPerso.findById(proye.getPersonaId()).orElse(null));
            proyeEditado.setNameProject(proye.getNombreProye());
            proyeEditado.setDescriptionProject(proye.getDescripcionProye());
            proyeEditado.setImgUrl(proye.getImgUrl());
            proyeEditado.setSourceCodeUrl(proye.getRepoUrl());
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
