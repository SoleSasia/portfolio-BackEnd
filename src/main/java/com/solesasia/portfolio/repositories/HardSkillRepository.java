package com.solesasia.portfolio.repositories;

import com.solesasia.portfolio.models.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends JpaRepository <HardSkill, Long> {
    
}
