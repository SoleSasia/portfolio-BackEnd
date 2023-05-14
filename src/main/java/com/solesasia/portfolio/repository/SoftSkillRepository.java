package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository <SoftSkill, Long> {
    
}
