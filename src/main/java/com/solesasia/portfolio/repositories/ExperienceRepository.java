package com.solesasia.portfolio.repositories;

import com.solesasia.portfolio.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository <Experience, Long> {
    
}
