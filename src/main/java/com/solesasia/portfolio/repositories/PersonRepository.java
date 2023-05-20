package com.solesasia.portfolio.repositories;

import com.solesasia.portfolio.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {
    
}
