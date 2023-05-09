package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Persona, Long> {
    
}
