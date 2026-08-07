package com.globitel.task.management.system.core.shared.exception;

import com.globitel.task.management.system.core.shared.exception.data.DefaultErrorMessage;
import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    private final ErrorMessage error;
    private final List<ErrorMessage> errors;

    public ApplicationException(ErrorMessage error,
                                Object... args) {
        this.error = DefaultErrorMessage.of(
                error.getCode(),
                String.format(error.getMessage(), args));
        this.errors = List.of(error);
    }

    public ApplicationException(ErrorMessage error) {
        this.error = error;
        this.errors = List.of(error);
    }


    public ApplicationException(List<ErrorMessage> errors) {
        this.errors = new ArrayList<>();

        for (ErrorMessage errorMessage : errors) {
            this.errors.add(DefaultErrorMessage.of(
                    errorMessage.getCode(),
                    errorMessage.getMessage()));

        }

        this.error = DefaultErrorMessage.of(
                errors.getFirst().getCode(),
                errors.getFirst().getMessage());
    }


}
