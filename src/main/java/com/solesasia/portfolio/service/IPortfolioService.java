
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.EduDto;
import com.solesasia.portfolio.dto.ExpeDto;
import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ProyeDto;
import com.solesasia.portfolio.model.Persona;
import java.util.List;


public interface IPortfolioService {
    
    //Lectura persona
    public Persona getPersona();
    
    //Modificar persona
    public boolean editarPersona(PersoDto perso);
    
    public PersoDto getPersoDto();
    
    public List<EduDto> listarEduDto();
    
    public List<ExpeDto> listarExpeDto();
    
    public List<HabTecnicaDto> listarHabTecnicaDto();
    
    public List<HabBlandaDto> listarHabBlandaDto();
    
    public List<ProyeDto> listarProyeDto();
   
    //Lectura porfolio
    public PortfolioDto getPortfolio();
    
}
