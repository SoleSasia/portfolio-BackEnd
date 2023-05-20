package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.HardSkillDto;
import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.services.IHardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${url.front}", maxAge = 3600)
public class HardSkillController {

    @Autowired
    private IHardSkillService hardService;

    @PostMapping("/newHardskill")
    public ResponseEntity<ResponseDto> addHardSkill(@RequestBody HardSkillDto hardSkillDto){
        hardService.createHardSkill(hardSkillDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteHardskill/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHardSkill(@PathVariable Long id) {
        hardService.deleteHardSkill(id);
    }

    @PutMapping ("/updateHardskill/{id}")
    public ResponseEntity<ResponseDto> updateHardSkill(@PathVariable Long id,
                                                       @RequestBody HardSkillDto hardSkillDto) {
        if (!hardService.updateHardSkill(id, hardSkillDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
