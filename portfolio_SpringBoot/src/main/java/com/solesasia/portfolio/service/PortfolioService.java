
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    @Autowired 
    PersonaRepository repoPerso;

    @Override
    public Optional<Persona> getPersona(Long id) {
        return repoPerso.findById(id);
    }

    @Override
    public String editarPersona(Long id, Persona perso) {
        return "";
    }

    //Implementado para pdoer compilar
    @Override
    public PortfolioDto getPortfolio() {
        PortfolioDto port = new PortfolioDto();
        return port;
    }
    
    
    
}
