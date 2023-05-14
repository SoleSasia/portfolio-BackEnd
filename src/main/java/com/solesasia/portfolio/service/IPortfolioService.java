
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.*;
import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.model.Person;
import java.util.List;

public interface IPortfolioService {
    
    //Lectura persona
    public Person getPerson();
    
    //Modificar persona
    public boolean updatePerson(PersonDto personDto);
    
    public PersonDto getPersonDto();
    
    public List<EducationDto> getEducationsDto();
    
    public List<ExperienceDto> getExperiencesDto();
    
    public List<HardSkillDto> getHardSkillsDto();
    
    public List<SoftSkillDto> getSoftSkillsDto();
    
    public List<ProjectDto> getProjectsDto();
   
    //Lectura porfolio
    public PortfolioDto getPortfolio();
    
}
