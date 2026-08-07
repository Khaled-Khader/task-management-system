package com.globitel.task.management.system.core.token.factory.response;

import java.time.Instant;

public record TokenResponse(
        String uuid,
        String token,
        Instant expiredDate
) {
}
