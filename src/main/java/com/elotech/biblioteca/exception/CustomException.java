package com.elotech.biblioteca.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    @Getter
    private final HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String messageError){
        super(messageError);
        this.httpStatus = httpStatus;
    }

    public CustomException(String message){
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
