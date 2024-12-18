package com.wakil.spring_multi_vendor.validator.NotBlankIfPresent;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = NotBlankIfPresentValidator.class


)
public @interface NotBlankIfPresent {
    String message() default "Field cannot be empty if present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
