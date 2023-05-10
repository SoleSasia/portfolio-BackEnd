
package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ResponseDto {
    
    private boolean isOk = true;
    private String message = "";

    public ResponseDto() {
    }

    public ResponseDto(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }
}
