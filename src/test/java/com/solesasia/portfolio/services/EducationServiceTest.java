package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.models.Education;
import com.solesasia.portfolio.models.Person;
import com.solesasia.portfolio.repositories.EducationRepository;
import com.solesasia.portfolio.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class EducationServiceTest {

    @InjectMocks //indico objeto que recibirá los mocks
    private EducationService educationService;

    @Mock
    private PersonRepository repoPerson;
    @Mock
    private EducationRepository repoEducation;
    @Mock
    private EducationDto eduDtoMock = new EducationDto(1L, 1L, "composicion musical", "2006-2010",
            "UNC", "carrera de 5 anios","...");

//    @Test
//    void createEducation(EducationDto eduDtoMock) {
//        Person person = repoPerson.findById(eduDtoMock.getPersonId()).orElse(null);
//        Education newEducation = new Education(person, eduDtoMock.getTitle(), eduDtoMock.getPeriod(),
//                eduDtoMock.getInstitution(), eduDtoMock.getDescription(), eduDtoMock.getLogoUrl());
//        repoEducation.save(newEducation);
//
//    }

    @Test
    void updateEducation() {
    }

    @Test
    void deleteEducation() {
    }
}