
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.ExperienceDto;
import com.solesasia.portfolio.models.Experience;
import com.solesasia.portfolio.models.Person;
import com.solesasia.portfolio.repositories.ExperienceRepository;
import com.solesasia.portfolio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {
    
    @Autowired public ExperienceRepository repoExperience;
    @Autowired public PersonRepository repoPerson;

    @Override
    public void createExperience(ExperienceDto experienceDto) {
        Person person = repoPerson.findById(experienceDto.getPersonId()).orElse(null);
        Experience newExperience = new Experience(person, experienceDto.getPosition(), experienceDto.getPeriod(),
                experienceDto.getCompany(), experienceDto.getDescription(), experienceDto.getLogoUrl());
        repoExperience.save(newExperience);
    }

    @Override
    public boolean updateExperience(Long id, ExperienceDto experienceDto) {
        if (!repoExperience.existsById(id)) {
            return false;
        } else {
            Experience updatedExperience = repoExperience.findById(id).orElse(null);
            updatedExperience.setPerson(repoPerson.findById(experienceDto.getPersonId()).orElse(null));
            updatedExperience.setPosition(experienceDto.getPosition());
            updatedExperience.setPeriod(experienceDto.getPeriod());
            updatedExperience.setCompany(experienceDto.getCompany());
            updatedExperience.setDescription(experienceDto.getDescription());
            updatedExperience.setLogoUrl(experienceDto.getLogoUrl());
            repoExperience.save(updatedExperience);
            return true;
        }
    }

    @Override
    public void deleteExperience(Long id) {
        repoExperience.deleteById(id);
    }

}
