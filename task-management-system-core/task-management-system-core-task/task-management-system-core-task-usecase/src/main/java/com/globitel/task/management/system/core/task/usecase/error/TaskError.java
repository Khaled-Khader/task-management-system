package com.globitel.task.management.system.core.task.usecase.error;

import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskError implements ErrorMessage {

    TASK_NOT_FOUND("TMS-TSK-UC-1000","Task not found"),
    ;
    private final String code;
    private final String message;
}
