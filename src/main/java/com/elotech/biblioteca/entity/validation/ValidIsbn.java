package com.elotech.biblioteca.entity.validation;

import com.elotech.biblioteca.entity.validator.ValidatorIsbn;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidatorIsbn.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIsbn {
    String message() default "O ISBN deve conter 10 ou 13 caracteres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
