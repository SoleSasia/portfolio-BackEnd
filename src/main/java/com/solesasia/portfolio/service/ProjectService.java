
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ProjectDto;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.model.Project;
import com.solesasia.portfolio.repository.PersonRepository;
import com.solesasia.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired public ProjectRepository repoProye;
    @Autowired public PersonRepository repoPerso;
    
    @Override
    public void crearProyecto(ProjectDto proye) {
        Person perso = repoPerso.findById(proye.getPersonId()).orElse(null);
        Project nuevoProye = new Project(perso, proye.getName(), proye.getDescription(), proye.getImgUrl(), proye.getSourceCodeUrl(), proye.getLiveUrl());
        repoProye.save(nuevoProye);
    }

    @Override
    public boolean editarProyecto(Long id, ProjectDto proye) {
        if (!repoProye.existsById(id)) {
            return false;
        } else {
            Project proyeEditado = repoProye.findById(id).orElse(null);
            proyeEditado.setPerson(repoPerso.findById(proye.getPersonId()).orElse(null));
            proyeEditado.setNameProject(proye.getName());
            proyeEditado.setDescriptionProject(proye.getDescription());
            proyeEditado.setImgUrl(proye.getImgUrl());
            proyeEditado.setSourceCodeUrl(proye.getSourceCodeUrl());
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
