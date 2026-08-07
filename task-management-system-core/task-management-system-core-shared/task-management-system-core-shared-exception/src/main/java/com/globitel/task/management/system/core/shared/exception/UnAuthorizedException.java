package com.globitel.task.management.system.core.shared.exception;


import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;

import java.util.List;

public class UnAuthorizedException extends ApplicationException{


    public UnAuthorizedException(ErrorMessage error) {
        super(error);
    }

    public UnAuthorizedException(ErrorMessage error, List<ErrorMessage> errors) {
        super(error, errors);
    }
}
