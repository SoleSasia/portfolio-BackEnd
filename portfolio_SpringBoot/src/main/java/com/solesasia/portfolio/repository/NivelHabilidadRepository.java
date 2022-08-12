package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.NivelHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelHabilidadRepository extends JpaRepository <NivelHabilidad, Long> {
    
}
