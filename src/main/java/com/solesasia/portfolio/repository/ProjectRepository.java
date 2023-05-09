
package com.solesasia.portfolio.repository;

import com.solesasia.portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Proyecto, Long> {
    
}
