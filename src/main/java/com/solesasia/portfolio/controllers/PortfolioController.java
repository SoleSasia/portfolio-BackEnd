package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.PersonDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.solesasia.portfolio.services.IPortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin (origins = "${url.front}", maxAge = 3600)
public class PortfolioController {
    
    //inyecta las dependencias necesarias para ejecutar las peticiones que vengan del cliente
    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDto> getPortfolio() {
        PortfolioDto portfolio = portfolioService.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    @PutMapping ("/updateperson")
    public ResponseEntity<ResponseDto> updatePerson(@RequestBody PersonDto personDto) {
        if (!portfolioService.updatePerson(personDto)){
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡La información personal ha sido actualizada!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}