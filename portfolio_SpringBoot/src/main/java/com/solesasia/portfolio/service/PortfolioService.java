
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PortfolioDto;
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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    //inyecta las dependencias necesarias
    @Autowired public PersonaRepository repoPersona;
    @Autowired public EducacionRepository repoEducacion;
    @Autowired public ExperienciaRepository repoExperiencia;
    @Autowired public HabilidadTecnicaRepository repoHabTecnica;
    @Autowired public HabilidadBlandaRepository repoHabBlanda;
    @Autowired public ProyectoRepository repoProyecto;
    
    
    
    @Override
    public Persona getPersona() {
        long personaId = 1; //"Harcodeo" id de la única persona disponible
        return repoPersona.findById(personaId).orElse(null);
    }

    @Override
    public boolean editarPersona(Persona perso) {
        long id = 1; //"Harcodeo" id de la única persona disponible
        perso.setId(id);
        repoPersona.save(perso);
        return true;
    }

    
    @Override
    public PortfolioDto getPortfolio() {

        // recupera los datos desde la persistencia
        Persona persona = this.getPersona();

        List<Educacion> educaciones = repoEducacion.findAll();

        List<Experiencia> experiencias = repoExperiencia.findAll();

        List<HabilidadTecnica> habilidadesTecnicas = repoHabTecnica.findAll();

        List<HabilidadBlanda> habilidadesBlandas = repoHabBlanda.findAll();

        List<Proyecto> proyectos = repoProyecto.findAll();

        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        
        portfolio.setPersona(persona);
        portfolio.setEducaciones(educaciones);
        portfolio.setExperiencias(experiencias);
        portfolio.setHabilidadesTecnicas(habilidadesTecnicas);
        portfolio.setHabilidadesBlandas(habilidadesBlandas);
        portfolio.setProyectos(proyectos);

        // entrega portfolio
        return portfolio;
    }
    
    
    
}
