package com.globitel.task.management.system.core.shared.exception;


import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;

public class NotAcceptableException extends ApplicationException {
    public NotAcceptableException(ErrorMessage error) {
        super(error);
    }

    public NotAcceptableException(ErrorMessage error, Object... args) {
        super(error, args);
    }
}
