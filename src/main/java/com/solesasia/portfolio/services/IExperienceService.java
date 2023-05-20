
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.ExperienceDto;

public interface IExperienceService {
    
    public void createExperience(ExperienceDto experienceDto);
       
    public boolean updateExperience(Long id, ExperienceDto experienceDto);
    
    public void deleteExperience(Long id);
}