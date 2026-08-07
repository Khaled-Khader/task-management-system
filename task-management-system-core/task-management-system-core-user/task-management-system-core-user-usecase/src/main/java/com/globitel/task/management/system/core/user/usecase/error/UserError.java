package com.globitel.task.management.system.core.user.usecase.error;

import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserError implements ErrorMessage {
    USER_NAME_EXISTS("TMS-USER-UC-1000", "Username already exists"),
    USER_EMAIL_EXISTS("TMS-USER-UC-2000", "Email already exists"),
    USER_NOT_FOUND("TMS-USER-UC-3000", "User not found"),
    USER_NOT_ACTIVE("TMS-USER-UC-4000", "User not active"),
    ;
    private final String code;
    private final String message;

}
