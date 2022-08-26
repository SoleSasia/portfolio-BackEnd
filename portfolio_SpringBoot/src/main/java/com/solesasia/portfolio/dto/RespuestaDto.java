
package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RespuestaDto {
    
    private boolean salioBien = true;
    private String msj = "";
       

    public RespuestaDto() {
    }

    public RespuestaDto(boolean salioBien, String msj) {
        this.salioBien = salioBien;
        this.msj = msj;
    }
    
    
}
