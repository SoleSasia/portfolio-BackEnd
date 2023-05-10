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
    @Autowired public PersonRepository repoPersona;
    @Autowired public EducationRepository repoEdu;
    @Autowired public ExperienceRepository repoExpe;
    @Autowired public HardSkillRepository repoTecnica;
    @Autowired public SoftSkillRepository repoBlanda;
    @Autowired public ProjectRepository repoProye;
    
    
    @Override
    public PortfolioDto getPortfolio() {

        // recupera los datos desde la persistencia
        PersonDto personDto = this.getPersoDto();
        List<EducationDto> listaEducationDto = this.listarEduDto();
        List<ExperienceDto> listaExperienceDto = this.listarExpeDto();
        List<hardSkillDto> listaHardSkillDto = this.listarHabTecnicaDto();
        List<SoftSkillDto> listaSoftSkillDto = this.listarHabBlandaDto();
        List<ProjectDto> listaProjectDto = this.listarProyeDto();
        
        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        //datos de persona
        portfolio.setPerson(personDto);
        //listas de secciones
        portfolio.setEducationDtos(listaEducationDto);
        portfolio.setExperienceDtos(listaExperienceDto);
        portfolio.setHardSkillDtos(listaHardSkillDto);
        portfolio.setSoftSkillDtos(listaSoftSkillDto);
        portfolio.setProjectDtos(listaProjectDto);

        // entrega portfolio
        return portfolio;
    }
    
    @Override
    public Person getPersona() {
        long personaId = 1; //"Harcodeo" id de la única persona disponible
        Person perso = repoPersona.findById(personaId).orElse(null);
        return perso;
    }
    
    @Override
    public PersonDto getPersoDto() {
        Person perso = this.getPersona();
        PersonDto personDto = new PersonDto(perso.getId(),perso.getName(), perso.getOccupation(),perso.getHomeBannerUrl(),perso.getEmail(),perso.getLinkedinUrl(),perso.getGithubUrl(),perso.getDescription(),perso.getProfilePicUrl());
        return personDto;
    }

    @Override
    public boolean editarPersona(PersonDto perso) {
        if (!repoPersona.existsById(perso.getId())){
            return false;
        } else {
            Person persoEditada = new Person(perso.getId(), perso.getName(), perso.getOccupation(), perso.getHomeBannerUrl(), perso.getEmail(), perso.getLinkedinUrl(), perso.getGithubUrl(), perso.getDescription(), perso.getImgUrl());
            repoPersona.save(persoEditada);
            return true;
        }
    }
    
    @Override
    public List<EducationDto> listarEduDto() {
        List<Education> listaEdu = repoEdu.findAll();
        List<EducationDto> listaEducationDto = new ArrayList<EducationDto>();
        for (int i = 0; i < listaEdu.size(); i++) {
            Education edu = listaEdu.get(i);
            EducationDto educationDto = new EducationDto(edu.getId(), edu.getPerson().getId(), edu.getTitle(), edu.getPeriod(), edu.getInstitution(), edu.getDescription(), edu.getLogoUrl());
            listaEducationDto.add(educationDto);
        }
        return listaEducationDto;
    }
    
    @Override
    public List<ExperienceDto> listarExpeDto() {
        List<Experience> listaExpe = repoExpe.findAll();
        List<ExperienceDto> listaExperienceDto = new ArrayList<ExperienceDto>();
        for (int i = 0; i < listaExpe.size(); i++) {
            Experience expe = listaExpe.get(i);
            ExperienceDto experienceDto = new ExperienceDto(expe.getId(), expe.getPerson().getId(), expe.getPosition(), expe.getPeriod(), expe.getCompany(), expe.getDescription(), expe.getLogoUrl());
            listaExperienceDto.add(experienceDto);
        }
        return listaExperienceDto;
    }
    
    @Override
    public List<hardSkillDto> listarHabTecnicaDto() {
        List<HardSkill> listaHabTecnica = repoTecnica.findAll();
        List<hardSkillDto> listaHardSkillDto = new ArrayList<hardSkillDto>();
        for (int i = 0; i < listaHabTecnica.size(); i++) {
            HardSkill habTecnica = listaHabTecnica.get(i);
            hardSkillDto hardSkillDto = new hardSkillDto(habTecnica.getId(), habTecnica.getPerson().getId(), habTecnica.getLevel().getId(), habTecnica.getSkillName(), habTecnica.getIconUrl());
            listaHardSkillDto.add(hardSkillDto);
        }
        return listaHardSkillDto;
    }
    
    @Override
    public List<SoftSkillDto> listarHabBlandaDto() {
        List<SoftSill> listahabBlanda = repoBlanda.findAll();
        List<SoftSkillDto> listaSoftSkillDto = new ArrayList<SoftSkillDto>();
        for (int i = 0; i < listahabBlanda.size(); i++) {
            SoftSill habBlanda = listahabBlanda.get(i);
            SoftSkillDto softSkillDto = new SoftSkillDto(habBlanda.getId(), habBlanda.getPerson().getId(), habBlanda.getSkillName(), habBlanda.getIconUrl());
            listaSoftSkillDto.add(softSkillDto);
        }
        return listaSoftSkillDto;
    }
    
    @Override
    public List<ProjectDto> listarProyeDto() {
        List<Project> listaProye = repoProye.findAll();
        List<ProjectDto> listaProjectDto = new ArrayList<ProjectDto>();
        for (int i = 0; i < listaProye.size(); i++) {
            Project proye = listaProye.get(i);
            ProjectDto projectDto = new ProjectDto(proye.getId(), proye.getPerson().getId(), proye.getNameProject(), proye.getDescriptionProject(), proye.getImgUrl(), proye.getSourceCodeUrl(), proye.getLiveUrl());
            listaProjectDto.add(projectDto);
        }
        return listaProjectDto;
    }
    
}
