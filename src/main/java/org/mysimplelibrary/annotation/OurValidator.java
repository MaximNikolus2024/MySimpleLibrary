package org.mysimplelibrary.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class OurValidator implements ConstraintValidator<OurValidation, String> {
    private String defaultMessage;

    @Override
    public void initialize(OurValidation constraintAnnotation) {
        this.defaultMessage = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            addConstraintViolation(context, "Password cannot be null");
            return false;
        }

        // начинается реализация критериев пароля
        List<String> errors = checkPasswordCriteria(password);

        if (!errors.isEmpty()) {
            addConstraintViolation(context, defaultMessage);
            for (String error : errors) {
                addConstraintViolation(context, error);
            }
            return false;
        }

        return true;

    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }

    private List<String> checkPasswordCriteria(String password) {
        // начинается реализация критериев пароля
        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Длина пароля долина быть не менее 8 символов");
        }
        // проверка на то, что пароль содержит хотя бы одну большую букву
        // ...

        // проверка на то, что пароль содержит хотя бы одну цифру
        // ...

        // ------- итого ------

        return errors;
    }
}
