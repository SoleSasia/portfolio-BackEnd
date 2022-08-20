
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PortfolioDTO;
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
import java.util.Optional;
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
    public Persona getPersona(Long id) {
        return repoPersona.findById(id).orElse(null);
    }

    @Override
    public boolean editarPersona(Long id, Persona perso) {
        if (!repoPersona.existsById(id)) {
            return false;
        }
        perso.setId(id);
        repoPersona.save(perso);
        return true;
    }

    
    @Override
    public PortfolioDTO getPortfolio(Long personaId) {

        // recupera los datos desde la persistencia
        Persona persona = this.getPersona(personaId);

        List<Educacion> listaEducacion = repoEducacion.findAll();

        List<Experiencia> listaExperiencia = repoExperiencia.findAll();

        List<HabilidadTecnica> listaHabilidadTecnica = repoHabTecnica.findAll();

        List<HabilidadBlanda> listaHabilidadBlanda = repoHabBlanda.findAll();

        List<Proyecto> listaProyecto = repoProyecto.findAll();

        // asigna los datos recuperados al portfolio
        PortfolioDTO portfolio = new PortfolioDTO();
        
        portfolio.setPersona(persona);
        portfolio.setListaEducacion(listaEducacion);
        portfolio.setListaExperiencia(listaExperiencia);
        portfolio.setListaHabilidadBlanda(listaHabilidadBlanda);
        portfolio.setListaHabilidadTecnica(listaHabilidadTecnica);
        portfolio.setListaProyecto(listaProyecto);

        // entrega portfolio
        return portfolio;
    }
    
    
    
}
