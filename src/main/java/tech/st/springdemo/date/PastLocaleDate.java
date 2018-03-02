package tech.st.springdemo.date;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.*;
import java.time.LocalDate;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastLocaleDate.PastValidator.class)
@Documented
public @interface PastLocaleDate {

    String message() default "{javax.validation.constrains.past}";

    Class<?>[] groups() default {};

    class PastValidator implements ConstraintValidator<PastLocaleDate, LocalDate> {


        @Override
        public void initialize(PastLocaleDate constraintAnnotation) {

        }

        @Override
        public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
            return value==null || value.isBefore(LocalDate.now());
        }
    }

}
