package com.elotech.biblioteca.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class RegraNegocioException extends RuntimeException{

    @Getter
    private final HttpStatus httpStatus;

    public RegraNegocioException(HttpStatus httpStatus, String messageError){
        super(messageError);
        this.httpStatus = httpStatus;
    }

    public RegraNegocioException(String message){
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
