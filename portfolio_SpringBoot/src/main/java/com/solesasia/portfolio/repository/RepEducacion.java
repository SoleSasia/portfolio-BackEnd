package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepEducacion extends JpaRepository <Educacion, Long> {
    
}
