package ru.job4j.ff.order.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public final class CheckBindResult {

    private CheckBindResult() {
    }

    public static String check(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            errors.forEach(
                    (error -> errorMsg.append(error.getField())
                            .append(" - ")
                            .append(error.getDefaultMessage())
                            .append(";"))
            );
        }
        return errorMsg.toString();
    }
}
