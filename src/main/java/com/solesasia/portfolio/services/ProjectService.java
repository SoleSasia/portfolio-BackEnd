
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.ProjectDto;
import com.solesasia.portfolio.models.Person;
import com.solesasia.portfolio.models.Project;
import com.solesasia.portfolio.repositories.PersonRepository;
import com.solesasia.portfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired public ProjectRepository repoProject;
    @Autowired public PersonRepository repoPerson;
    
    @Override
    public void createProject(ProjectDto projectDto) {
        Person person = repoPerson.findById(projectDto.getPersonId()).orElse(null);
        Project newProject = new Project(person, projectDto.getName(), projectDto.getDescription(), 
                projectDto.getImgUrl(), projectDto.getSourceCodeUrl(), projectDto.getLiveUrl());
        repoProject.save(newProject);
    }

    @Override
    public boolean updateProject(Long id, ProjectDto projectDto) {
        if (!repoProject.existsById(id)) {
            return false;
        } else {
            Project updatedProject = repoProject.findById(id).orElse(null);
            updatedProject.setPerson(repoPerson.findById(projectDto.getPersonId()).orElse(null));
            updatedProject.setNameProject(projectDto.getName());
            updatedProject.setDescriptionProject(projectDto.getDescription());
            updatedProject.setImgUrl(projectDto.getImgUrl());
            updatedProject.setSourceCodeUrl(projectDto.getSourceCodeUrl());
            updatedProject.setLiveUrl(projectDto.getLiveUrl());
            repoProject.save(updatedProject);
            return true;
        }
    }

    @Override
    public void deleteProject(Long id) {
        repoProject.deleteById(id);
    }
}
