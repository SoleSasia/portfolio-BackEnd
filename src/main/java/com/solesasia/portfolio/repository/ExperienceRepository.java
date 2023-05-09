package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository <Experiencia, Long> {
    
}
