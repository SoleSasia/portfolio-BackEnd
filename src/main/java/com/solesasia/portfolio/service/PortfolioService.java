package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;
import com.solesasia.portfolio.dto.ExpeDto;
import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ProyeDto;
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
        PersoDto persoDto = this.getPersoDto();
        List<EduDto> listaEduDto = this.listarEduDto();
        List<ExpeDto> listaExpeDto = this.listarExpeDto();
        List<HabTecnicaDto> listaHabTecnicaDto = this.listarHabTecnicaDto();
        List<HabBlandaDto> listaHabBlandaDto = this.listarHabBlandaDto();
        List<ProyeDto> listaProyeDto = this.listarProyeDto();
        
        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        //datos de persona
        portfolio.setPersona(persoDto);
        //listas de secciones
        portfolio.setEducaciones(listaEduDto);
        portfolio.setExperiencias(listaExpeDto);
        portfolio.setHabTecnicas(listaHabTecnicaDto);
        portfolio.setHabBlandas(listaHabBlandaDto);
        portfolio.setProyectos(listaProyeDto);

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
    public PersoDto getPersoDto() {
        Person perso = this.getPersona();
        PersoDto persoDto = new PersoDto(perso.getId(),perso.getName(), perso.getOccupation(),perso.getHomeBannerUrl(),perso.getEmail(),perso.getLinkedinUrl(),perso.getGithubUrl(),perso.getDescription(),perso.getProfilePicUrl());
        return persoDto;
    }

    @Override
    public boolean editarPersona(PersoDto perso) {
        if (!repoPersona.existsById(perso.getId())){
            return false;
        } else {
            Person persoEditada = new Person(perso.getId(), perso.getNombre(), perso.getOcupacion(), perso.getBannerUrl(), perso.getEmail(), perso.getLinkedinUrl(), perso.getGithubUrl(), perso.getDescripcion(), perso.getImgUrl());
            repoPersona.save(persoEditada);
            return true;
        }
    }
    
    @Override
    public List<EduDto> listarEduDto() {
        List<Education> listaEdu = repoEdu.findAll();
        List<EduDto> listaEduDto = new ArrayList<EduDto>();
        for (int i = 0; i < listaEdu.size(); i++) {
            Education edu = listaEdu.get(i);
            EduDto eduDto = new EduDto(edu.getId(), edu.getPerson().getId(), edu.getTitle(), edu.getPeriod(), edu.getInstitution(), edu.getDescription(), edu.getLogoUrl());
            listaEduDto.add(eduDto);
        }
        return listaEduDto;
    }
    
    @Override
    public List<ExpeDto> listarExpeDto() {
        List<Experience> listaExpe = repoExpe.findAll();
        List<ExpeDto> listaExpeDto = new ArrayList<ExpeDto>();
        for (int i = 0; i < listaExpe.size(); i++) {
            Experience expe = listaExpe.get(i);
            ExpeDto expeDto = new ExpeDto(expe.getId(), expe.getPerson().getId(), expe.getPosition(), expe.getPeriod(), expe.getCompany(), expe.getDescription(), expe.getLogoUrl());
            listaExpeDto.add(expeDto);
        }
        return listaExpeDto;
    }
    
    @Override
    public List<HabTecnicaDto> listarHabTecnicaDto() {
        List<HardSkill> listaHabTecnica = repoTecnica.findAll();
        List<HabTecnicaDto> listaHabTecnicaDto = new ArrayList<HabTecnicaDto>();
        for (int i = 0; i < listaHabTecnica.size(); i++) {
            HardSkill habTecnica = listaHabTecnica.get(i);
            HabTecnicaDto habTecnicaDto = new HabTecnicaDto(habTecnica.getId(), habTecnica.getPerson().getId(), habTecnica.getLevel().getId(), habTecnica.getSkillName(), habTecnica.getIconUrl());
            listaHabTecnicaDto.add(habTecnicaDto);
        }
        return listaHabTecnicaDto;
    }
    
    @Override
    public List<HabBlandaDto> listarHabBlandaDto() {
        List<SoftSill> listahabBlanda = repoBlanda.findAll();
        List<HabBlandaDto> listaHabBlandaDto = new ArrayList<HabBlandaDto>();
        for (int i = 0; i < listahabBlanda.size(); i++) {
            SoftSill habBlanda = listahabBlanda.get(i);
            HabBlandaDto habBlandaDto = new HabBlandaDto(habBlanda.getId(), habBlanda.getPerson().getId(), habBlanda.getSkillName(), habBlanda.getIconUrl());
            listaHabBlandaDto.add(habBlandaDto);
        }
        return listaHabBlandaDto;
    }
    
    @Override
    public List<ProyeDto> listarProyeDto() {
        List<Project> listaProye = repoProye.findAll();
        List<ProyeDto> listaProyeDto = new ArrayList<ProyeDto>();
        for (int i = 0; i < listaProye.size(); i++) {
            Project proye = listaProye.get(i);
            ProyeDto proyeDto = new ProyeDto(proye.getId(), proye.getPerson().getId(), proye.getNameProject(), proye.getDescriptionProject(), proye.getImgUrl(), proye.getSourceCodeUrl(), proye.getLiveUrl());
            listaProyeDto.add(proyeDto);
        }
        return listaProyeDto;
    }
    
}
