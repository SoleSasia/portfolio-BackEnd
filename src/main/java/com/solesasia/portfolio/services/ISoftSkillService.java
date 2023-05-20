
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.SoftSkillDto;

public interface ISoftSkillService {
    
    public void createSoftSkill(SoftSkillDto softSkillDto);
    
    public boolean updateSoftSkill(Long id, SoftSkillDto softSkillDto);
    
    public void deleteSoftSkill(Long id);
    
}
