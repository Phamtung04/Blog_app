package com.vti.blogapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.*;

    @Documented
    @Constraint(validatedBy = PostIdExistsValidatoer.class)
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PostIdExists {
        String message() default "{post.id.Exists.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
