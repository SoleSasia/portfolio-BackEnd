package com.solesasia.portfolio.repositories;

import com.solesasia.portfolio.models.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillLevelRepository extends JpaRepository <SkillLevel, Long> {
    
}
