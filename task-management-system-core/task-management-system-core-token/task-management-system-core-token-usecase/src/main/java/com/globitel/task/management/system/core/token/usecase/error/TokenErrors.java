package com.globitel.task.management.system.core.token.usecase.error;

import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenErrors implements ErrorMessage {

    TOKEN_NOT_FOUND("TMS-TKN-UC-1000","Token not found"),
    ROLE_NOT_MATCH("TMS-TKN-UC-2000","Role not found")

    ;
    private final String code;
    private final String message;

}
