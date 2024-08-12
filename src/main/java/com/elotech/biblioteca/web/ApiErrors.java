package com.elotech.biblioteca.web;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    @Getter
    private String cause = "Causa não informada";

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String messageError){
        this.errors = Arrays.asList(messageError);
    }

    public ApiErrors(String messageError,String cause) {
        this.cause = cause;
        this.errors = Arrays.asList(messageError);
    }
}
