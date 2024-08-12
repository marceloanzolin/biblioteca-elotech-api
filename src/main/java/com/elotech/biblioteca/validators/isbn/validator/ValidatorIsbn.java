package com.elotech.biblioteca.validators.isbn.validator;

import com.elotech.biblioteca.validators.isbn.validation.ValidIsbn;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorIsbn implements ConstraintValidator<ValidIsbn, String> {

    @Override
    public void initialize(ValidIsbn constraintAnnotation) {
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }
        String numerosIsbn = isbn.replaceAll("[^\\d]", "");
        return numerosIsbn.length() == 10 || numerosIsbn.length() == 13;
    }
}
