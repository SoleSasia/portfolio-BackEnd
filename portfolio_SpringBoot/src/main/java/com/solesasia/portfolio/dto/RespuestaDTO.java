
package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RespuestaDTO {
    
    private String respuesta = "";
    

    public RespuestaDTO() {
    }

    public RespuestaDTO(String resp) {
        this.respuesta = resp;
    }
    
    
}
