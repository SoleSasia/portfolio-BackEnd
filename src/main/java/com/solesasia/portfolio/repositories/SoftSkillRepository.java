package com.solesasia.portfolio.repositories;

import com.solesasia.portfolio.models.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository <SoftSkill, Long> {
    
}
