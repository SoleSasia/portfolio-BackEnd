package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillLevelRepository extends JpaRepository <SkillLevel, Long> {
    
}
