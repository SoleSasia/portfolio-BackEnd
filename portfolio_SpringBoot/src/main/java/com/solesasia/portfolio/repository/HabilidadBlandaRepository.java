package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.HabilidadBlanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadBlandaRepository extends JpaRepository <HabilidadBlanda, Long> {
    
}
