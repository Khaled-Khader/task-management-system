package com.globitel.task.management.system.core.shared.usecase;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.exception.data.DefaultErrorMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
public abstract class ValidatorConsumerUseCase<REQ> {

    private final Validator validator;

    public void execute(REQ request){
        Set<ConstraintViolation<REQ>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            List<DefaultErrorMessage> errors = violations.stream()
                    .map(violation -> DefaultErrorMessage.of(violation.getPropertyPath().toString(), violation.getMessage()))
                    .toList();
            throw new BadRequestException(errors);
        }

        doExecute(request);
    }

    protected abstract void doExecute(REQ request);

}
