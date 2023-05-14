
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HardSkillDto;
import com.solesasia.portfolio.model.HardSkill;
import com.solesasia.portfolio.model.SkillLevel;
import com.solesasia.portfolio.model.Person;
import com.solesasia.portfolio.repository.HardSkillRepository;
import com.solesasia.portfolio.repository.SkillLevelRepository;
import com.solesasia.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService implements IHardSkillService {

    @Autowired public HardSkillRepository repoHardSkill;
    @Autowired public PersonRepository repoPerson;
    @Autowired public SkillLevelRepository repoLevel;

    @Override
    public void createHardSkill(HardSkillDto hardSkillDto) {
        Person person = repoPerson.findById(hardSkillDto.getPersonId()).orElse(null);
        SkillLevel skillLevel = repoLevel.findById(hardSkillDto.getLevelId()).orElse(null);
        HardSkill newHardSkill = new HardSkill(person, skillLevel, hardSkillDto.getSkillName(), hardSkillDto.getIconUrl());
        repoHardSkill.save(newHardSkill);
    }             
                
    @Override
    public boolean updateHardSkill(Long id, HardSkillDto hardSkillDto) {
        if (!repoHardSkill.existsById(id)) {
            return false;
        } else {
            HardSkill updatedHardskill = repoHardSkill.findById(id).orElse(null);
            updatedHardskill.setPerson(repoPerson.findById(hardSkillDto.getPersonId()).orElse(null));
            updatedHardskill.setLevel(repoLevel.findById(hardSkillDto.getLevelId()).orElse(null));
            updatedHardskill.setSkillName(hardSkillDto.getSkillName());
            updatedHardskill.setIconUrl(hardSkillDto.getIconUrl());
            repoHardSkill.save(updatedHardskill);
            return true;
        }
    }

    @Override
    public void deleteHardSkill(Long id) {
        repoHardSkill.deleteById(id);
    }

    }
