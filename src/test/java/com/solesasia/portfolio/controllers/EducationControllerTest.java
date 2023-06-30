package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.repositories.EducationRepository;
import com.solesasia.portfolio.services.EducationService;
import com.solesasia.portfolio.services.IEducationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class EducationControllerTest {

    /*@InjectMocks //en este objeto se injectan los mocks
    private EducationController controller;

    @Mock
    private IEducationService service;

    @Test
    void addEducation() {
        EducationDto eduDtoMock = new EducationDto(1L, 1L, "composicion musical", "2006-2010",
                "UNC", "carrera de 5 anios","...");
        //ResponseDto respDtoMock = new ResponseDto(true, "¡El elemento ha sido agregado!");;
        service.createEducation(eduDtoMock);
        controller.addEducation(eduDtoMock);
    }*/

    @Test
    void deleteEducation() {
    }

    @Test
    void updateEducation() {
    }
}