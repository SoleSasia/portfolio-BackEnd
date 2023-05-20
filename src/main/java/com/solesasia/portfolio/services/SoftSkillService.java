
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.SoftSkillDto;
import com.solesasia.portfolio.models.SoftSkill;
import com.solesasia.portfolio.models.Person;
import com.solesasia.portfolio.repositories.SoftSkillRepository;
import com.solesasia.portfolio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService implements ISoftSkillService {

    @Autowired public SoftSkillRepository repoSoftSkill;
    @Autowired public PersonRepository repoPerson;

    @Override
    public void createSoftSkill(SoftSkillDto softSkillDto) {
        Person person = repoPerson.findById(softSkillDto.getPersonId()).orElse(null);
        SoftSkill newSoftSkill = new SoftSkill(person, softSkillDto.getSkillName(), softSkillDto.getIconUrl());
        repoSoftSkill.save(newSoftSkill);
    }

    @Override
    public boolean updateSoftSkill(Long id, SoftSkillDto softSkillDto) {
        if (!repoSoftSkill.existsById(id)) {
            return false;
        } else {
            SoftSkill updatedSoftSkill = repoSoftSkill.findById(id).orElse(null);
            updatedSoftSkill.setPerson(repoPerson.findById(softSkillDto.getPersonId()).orElse(null));
            updatedSoftSkill.setSkillName(softSkillDto.getSkillName());
            updatedSoftSkill.setIconUrl(softSkillDto.getIconUrl());
            repoSoftSkill.save(updatedSoftSkill);
            return true;
        }
    }

    @Override
    public void deleteSoftSkill(Long id) {
        repoSoftSkill.deleteById(id);
    }

}