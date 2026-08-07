package com.globitel.task.management.system.presentation.spring.boot.filter.response;

import java.time.Instant;

public record ErrorResponse(
        String code,
        String message,
        Instant timestamp
) {
}
