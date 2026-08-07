package com.globitel.task.management.system.presentation.spring.boot.exception.response;

import java.time.Instant;

public record ExceptionResponse(
        String message,
        String code,
        Instant time
) {
}
