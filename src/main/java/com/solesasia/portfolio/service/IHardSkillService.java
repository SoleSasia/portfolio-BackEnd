package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.HardSkillDto;

public interface IHardSkillService {
    
    public void createHardSkill(HardSkillDto hardSkillDto);
    
    public boolean updateHardSkill(Long id, HardSkillDto hardSkillDto);
    
    public void deleteHardSkill(Long id);
    
}
