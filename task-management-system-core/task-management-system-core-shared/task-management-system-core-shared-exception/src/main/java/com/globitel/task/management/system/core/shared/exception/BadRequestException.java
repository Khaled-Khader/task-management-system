package com.globitel.task.management.system.core.shared.exception;

import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;

import java.util.List;

public class BadRequestException extends ApplicationException{
    public BadRequestException(List<? extends ErrorMessage> errors) {
        super((List<ErrorMessage>) errors);
    }

    public BadRequestException(ErrorMessage error) {
        super(error);
    }

    public BadRequestException(ErrorMessage error, Object... args) {
        super(error, args);
    }
}
