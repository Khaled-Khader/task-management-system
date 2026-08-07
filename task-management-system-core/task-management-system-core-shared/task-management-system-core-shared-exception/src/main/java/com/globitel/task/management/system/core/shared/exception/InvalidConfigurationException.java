package com.globitel.task.management.system.core.shared.exception;


import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;

public class InvalidConfigurationException extends ApplicationException {
    public InvalidConfigurationException(ErrorMessage error) {
        super(error);
    }

    public InvalidConfigurationException(ErrorMessage error, Object... args) {
        super(error, args);
    }
}
