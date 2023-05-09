package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.HabilidadTecnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends JpaRepository <HabilidadTecnica, Long> {
    
}
