package com.globitel.task.management.system.core.shared.exception.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class DefaultErrorMessage implements ErrorMessage {
    private final String message;
    private final String code;
}
