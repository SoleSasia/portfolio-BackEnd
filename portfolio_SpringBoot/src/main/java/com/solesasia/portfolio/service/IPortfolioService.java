
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.model.Persona;
import java.util.Optional;


public interface IPortfolioService {
    
    //Lectura persona
    public Optional<Persona> getPersona(Long id);
    //Modificar persona
    public String editarPersona(Long id, Persona perso);
    //Lectura porfolio
    public PortfolioDto getPortfolio();
    
}
