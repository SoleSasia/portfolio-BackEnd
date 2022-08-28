
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.model.Persona;


public interface IPortfolioService {
    
    //Lectura persona
    public Persona getPersona();
    
    //Modificar persona
    public boolean editarPersona(PersoDto perso);
   
    //Lectura porfolio
    public PortfolioDto getPortfolio();
    
}
