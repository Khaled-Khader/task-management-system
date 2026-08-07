package com.globitel.task.management.system.core.shared.exception;


import com.globitel.task.management.system.core.shared.exception.data.DefaultErrorMessage;
import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;

public class ServerInternalError extends ApplicationException {
    public ServerInternalError(String errorMessage) {
        super(DefaultErrorMessage.of("", errorMessage));
    }

    public ServerInternalError(ErrorMessage error, Object... args) {
        super(error, args);
    }
}
