
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    //inyecta las dependencias necesarias
    @Autowired public PersonaRepository repoPersona; 
    
    
    @Override
    public Persona getPersona() {
        long personaId = 1; //"Harcodeo" id de la única persona disponible
        Persona perso = repoPersona.findById(personaId).orElse(null);
        return perso;
    }

    @Override
    public boolean editarPersona(PersoDto perso) {
    //long id = 1; //"Harcodeo" id de la única persona disponible
        //perso.setId(id);
        if (!repoPersona.existsById(perso.getId())){
            return false;
        } else {
            Persona persoEditada = new Persona(perso.getId(), perso.getNombre(), perso.getOcupacion(), perso.getBannerUrl(), perso.getEmail(), perso.getLinkedinUrl(), perso.getGithubUrl(), perso.getDescripcion(), perso.getImgUrl());
            repoPersona.save(persoEditada);
            return true;
        }
    }

    
    @Override
    public PortfolioDto getPortfolio() {

        // recupera los datos desde la persistencia
        Persona perso = this.getPersona();

        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        
        portfolio.setId(perso.getId());
        portfolio.setNombre(perso.getNombre());
        portfolio.setOcupacion(perso.getOcupacion());
        portfolio.setBannerUrl(perso.getBannerUrl());
        portfolio.setEmail(perso.getEmail());
        portfolio.setLinkedinUrl(perso.getLinkedinUrl());
        portfolio.setGithubUrl(perso.getGithubUrl());
        portfolio.setDescripcion(perso.getDescripcion());
        portfolio.setImgUrl(perso.getImgUrl());
        portfolio.setEducaciones(perso.getEducaciones());
        portfolio.setExperiencias(perso.getExperiencias());
        portfolio.setHabTecnicas(perso.getHabTecnicas());
        portfolio.setHabBlandas(perso.getHabBlandas());
        portfolio.setProyectos(perso.getProyectos());

        // entrega portfolio
        return portfolio;
    }
    
    
}
