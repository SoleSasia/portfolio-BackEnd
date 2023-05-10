
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.*;
import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.model.Person;
import java.util.List;


public interface IPortfolioService {
    
    //Lectura persona
    public Person getPersona();
    
    //Modificar persona
    public boolean editarPersona(PersonDto perso);
    
    public PersonDto getPersoDto();
    
    public List<EducationDto> listarEduDto();
    
    public List<ExperienceDto> listarExpeDto();
    
    public List<hardSkillDto> listarHabTecnicaDto();
    
    public List<SoftSkillDto> listarHabBlandaDto();
    
    public List<ProjectDto> listarProyeDto();
   
    //Lectura porfolio
    public PortfolioDto getPortfolio();
    
}
