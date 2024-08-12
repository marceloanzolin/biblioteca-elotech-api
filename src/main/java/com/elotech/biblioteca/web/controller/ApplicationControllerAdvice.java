package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.web.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiErrors> handleCustomException(CustomException ex){
        String mensagemErro = ex.getMessage();
        String cause = ex.getCause() != null ? ex.getCause().getMessage() : "Causa não informada" ;
        ApiErrors apiErrors = new ApiErrors(mensagemErro,cause);
        return new ResponseEntity<>(apiErrors,ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException( MethodArgumentNotValidException ex ){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}
