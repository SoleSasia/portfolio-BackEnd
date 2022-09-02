package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;
import com.solesasia.portfolio.dto.ExpeDto;
import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ProyeDto;
import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
import com.solesasia.portfolio.repository.EducacionRepository;
import com.solesasia.portfolio.repository.ExperienciaRepository;
import com.solesasia.portfolio.repository.HabilidadBlandaRepository;
import com.solesasia.portfolio.repository.HabilidadTecnicaRepository;
import com.solesasia.portfolio.repository.PersonaRepository;
import com.solesasia.portfolio.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    //inyecta las dependencias necesarias
    @Autowired public PersonaRepository repoPersona; 
    @Autowired public EducacionRepository repoEdu;
    @Autowired public ExperienciaRepository repoExpe;
    @Autowired public HabilidadTecnicaRepository repoTecnica;
    @Autowired public HabilidadBlandaRepository repoBlanda;
    @Autowired public ProyectoRepository repoProye;
    
    
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
    public Persona getPersona() {
        long personaId = 1; //"Harcodeo" id de la única persona disponible
        Persona perso = repoPersona.findById(personaId).orElse(null);
        return perso;
    }
    
    @Override
    public PersoDto getPersoDto() {
        Persona perso = this.getPersona();
        PersoDto persoDto = new PersoDto(perso.getId(),perso.getNombre(), perso.getOcupacion(),perso.getBannerUrl(),perso.getEmail(),perso.getLinkedinUrl(),perso.getGithubUrl(),perso.getDescripcion(),perso.getImgUrl());
        return persoDto;
    }

    @Override
    public boolean editarPersona(PersoDto perso) {
        if (!repoPersona.existsById(perso.getId())){
            return false;
        } else {
            Persona persoEditada = new Persona(perso.getId(), perso.getNombre(), perso.getOcupacion(), perso.getBannerUrl(), perso.getEmail(), perso.getLinkedinUrl(), perso.getGithubUrl(), perso.getDescripcion(), perso.getImgUrl());
            repoPersona.save(persoEditada);
            return true;
        }
    }
    
    @Override
    public List<EduDto> listarEduDto() {
        List<Educacion> listaEdu = repoEdu.findAll();
        List<EduDto> listaEduDto = new ArrayList<EduDto>();
        for (int i = 0; i < listaEdu.size(); i++) {
            Educacion edu = listaEdu.get(i);
            EduDto eduDto = new EduDto(edu.getId(), edu.getPersona().getId(), edu.getTituloEdu(), edu.getPeriodoEdu(), edu.getInstitucionEdu(), edu.getDescripcionEdu(), edu.getUrlLogoEdu());
            listaEduDto.add(eduDto);
        }
        return listaEduDto;
    }
    
    @Override
    public List<ExpeDto> listarExpeDto() {
        List<Experiencia> listaExpe = repoExpe.findAll();
        List<ExpeDto> listaExpeDto = new ArrayList<ExpeDto>();
        for (int i = 0; i < listaExpe.size(); i++) {
            Experiencia expe = listaExpe.get(i);
            ExpeDto expeDto = new ExpeDto(expe.getId(), expe.getPersona().getId(), expe.getPuestoExpe(), expe.getPeriodoExpe(), expe.getOrganismoExpe(), expe.getDescripcionExpe(), expe.getUrlLogoExpe());
            listaExpeDto.add(expeDto);
        }
        return listaExpeDto;
    }
    
    @Override
    public List<HabTecnicaDto> listarHabTecnicaDto() {
        List<HabilidadTecnica> listaHabTecnica = repoTecnica.findAll();
        List<HabTecnicaDto> listaHabTecnicaDto = new ArrayList<HabTecnicaDto>();
        for (int i = 0; i < listaHabTecnica.size(); i++) {
            HabilidadTecnica habTecnica = listaHabTecnica.get(i);
            HabTecnicaDto habTecnicaDto = new HabTecnicaDto(habTecnica.getId(), habTecnica.getPersona().getId(), habTecnica.getNivel().getId(), habTecnica.getNombreHabilidad(), habTecnica.getUrlIcono());
            listaHabTecnicaDto.add(habTecnicaDto);
        }
        return listaHabTecnicaDto;
    }
    
    @Override
    public List<HabBlandaDto> listarHabBlandaDto() {
        List<HabilidadBlanda> listahabBlanda = repoBlanda.findAll();
        List<HabBlandaDto> listaHabBlandaDto = new ArrayList<HabBlandaDto>();
        for (int i = 0; i < listahabBlanda.size(); i++) {
            HabilidadBlanda habBlanda = listahabBlanda.get(i);
            HabBlandaDto habBlandaDto = new HabBlandaDto(habBlanda.getId(), habBlanda.getPersona().getId(), habBlanda.getNombreHabilidad(), habBlanda.getUrlIcono());
            listaHabBlandaDto.add(habBlandaDto);
        }
        return listaHabBlandaDto;
    }
    
    @Override
    public List<ProyeDto> listarProyeDto() {
        List<Proyecto> listaProye = repoProye.findAll();
        List<ProyeDto> listaProyeDto = new ArrayList<ProyeDto>();
        for (int i = 0; i < listaProye.size(); i++) {
            Proyecto proye = listaProye.get(i);
            ProyeDto proyeDto = new ProyeDto(proye.getId(), proye.getPersona().getId(), proye.getNombreProye(), proye.getDescripcionProye(), proye.getImgUrl(), proye.getRepoUrl(), proye.getLiveUrl());
            listaProyeDto.add(proyeDto);
        }
        return listaProyeDto;
    }
    
}
