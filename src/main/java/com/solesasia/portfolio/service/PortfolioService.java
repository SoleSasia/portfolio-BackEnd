package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.*;
import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.model.*;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.repository.EducationRepository;
import com.solesasia.portfolio.repository.ExperienceRepository;
import com.solesasia.portfolio.repository.SoftSkillRepository;
import com.solesasia.portfolio.repository.HardSkillRepository;
import com.solesasia.portfolio.repository.PersonRepository;
import com.solesasia.portfolio.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    //inyecta las dependencias necesarias
    @Autowired public PersonRepository repoPerson;
    @Autowired public EducationRepository repoEducation;
    @Autowired public ExperienceRepository repoExperience;
    @Autowired public HardSkillRepository repoHardSkill;
    @Autowired public SoftSkillRepository repoSoftSkill;
    @Autowired public ProjectRepository repoProject;
    
    @Override
    public PortfolioDto getPortfolio() {

        // recupera los datos desde la persistencia
        PersonDto personDto = this.getPersonDto();
        List<EducationDto> educationsDto = this.getEducationsDto();
        List<ExperienceDto> experiencesDto = this.getExperiencesDto();
        List<HardSkillDto> hardSkillsDto = this.getHardSkillsDto();
        List<SoftSkillDto> softSkillsDto = this.getSoftSkillsDto();
        List<ProjectDto> projectsDto = this.getProjectsDto();
        
        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        //datos de persona
        portfolio.setPerson(personDto);
        //listas de secciones
        portfolio.setEducationDtos(educationsDto);
        portfolio.setExperienceDtos(experiencesDto);
        portfolio.setHardSkillDtos(hardSkillsDto);
        portfolio.setSoftSkillDtos(softSkillsDto);
        portfolio.setProjectDtos(projectsDto);

        // entrega portfolio
        return portfolio;
    }
    
    @Override
    public Person getPerson() {
        long personId = 1; //"Harcodeo" id de la única persona disponible
        Person person = repoPerson.findById(personId).orElse(null);
        return person;
    }
    
    @Override
    public PersonDto getPersonDto() {
        Person person = this.getPerson();
        PersonDto personDto = new PersonDto(person.getId(),person.getName(), person.getOccupation(),person.getHomeBannerUrl(),person.getEmail(),person.getLinkedinUrl(),person.getGithubUrl(),person.getDescription(),person.getProfilePicUrl());
        return personDto;
    }

    @Override
    public boolean updatePerson(PersonDto personDto) {
        if (!repoPerson.existsById(personDto.getId())){
            return false;
        } else {
            Person updatedPerson = new Person(personDto.getId(), personDto.getName(), personDto.getOccupation(), personDto.getHomeBannerUrl(), personDto.getEmail(), personDto.getLinkedinUrl(), personDto.getGithubUrl(), personDto.getDescription(), personDto.getImgUrl());
            repoPerson.save(updatedPerson);
            return true;
        }
    }
    
    @Override
    public List<EducationDto> getEducationsDto() {
        List<Education> educationAll = repoEducation.findAll();
        List<EducationDto> educationsDto = new ArrayList<EducationDto>();
        for (int i = 0; i < educationAll.size(); i++) {
            Education education = educationAll.get(i);
            EducationDto educationDto = new EducationDto(education.getId(), education.getPerson().getId(), education.getTitle(), education.getPeriod(), education.getInstitution(), education.getDescription(), education.getLogoUrl());
            educationsDto.add(educationDto);
        }
        return educationsDto;
    }
    
    @Override
    public List<ExperienceDto> getExperiencesDto() {
        List<Experience> experienceAll = repoExperience.findAll();
        List<ExperienceDto> experiencesDto = new ArrayList<ExperienceDto>();
        for (int i = 0; i < experienceAll.size(); i++) {
            Experience experience = experienceAll.get(i);
            ExperienceDto experienceDto = new ExperienceDto(experience.getId(), experience.getPerson().getId(), experience.getPosition(), experience.getPeriod(), experience.getCompany(), experience.getDescription(), experience.getLogoUrl());
            experiencesDto.add(experienceDto);
        }
        return experiencesDto;
    }
    
    @Override
    public List<HardSkillDto> getHardSkillsDto() {
        List<HardSkill> hardSkillAll = repoHardSkill.findAll();
        List<HardSkillDto> hardSkillsDto = new ArrayList<HardSkillDto>();
        for (int i = 0; i < hardSkillAll.size(); i++) {
            HardSkill hardSkill = hardSkillAll.get(i);
            HardSkillDto hardSkillDto = new HardSkillDto(hardSkill.getId(), hardSkill.getPerson().getId(), hardSkill.getLevel().getId(), hardSkill.getSkillName(), hardSkill.getIconUrl());
            hardSkillsDto.add(hardSkillDto);
        }
        return hardSkillsDto;
    }
    
    @Override
    public List<SoftSkillDto> getSoftSkillsDto() {
        List<SoftSkill> softSkillAll = repoSoftSkill.findAll();
        List<SoftSkillDto> softSkillsDto = new ArrayList<SoftSkillDto>();
        for (int i = 0; i < softSkillAll.size(); i++) {
            SoftSkill softSkill = softSkillAll.get(i);
            SoftSkillDto softSkillDto = new SoftSkillDto(softSkill.getId(), softSkill.getPerson().getId(), softSkill.getSkillName(), softSkill.getIconUrl());
            softSkillsDto.add(softSkillDto);
        }
        return softSkillsDto;
    }
    
    @Override
    public List<ProjectDto> getProjectsDto() {
        List<Project> projectAll = repoProject.findAll();
        List<ProjectDto> projectsDto = new ArrayList<ProjectDto>();
        for (int i = 0; i < projectAll.size(); i++) {
            Project project = projectAll.get(i);
            ProjectDto projectDto = new ProjectDto(project.getId(), project.getPerson().getId(), project.getNameProject(), project.getDescriptionProject(), project.getImgUrl(), project.getSourceCodeUrl(), project.getLiveUrl());
            projectsDto.add(projectDto);
        }
        return projectsDto;
    }
    
}