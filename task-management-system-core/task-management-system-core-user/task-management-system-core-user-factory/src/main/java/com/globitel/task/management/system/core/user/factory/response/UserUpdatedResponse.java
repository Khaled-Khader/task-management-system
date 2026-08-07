package com.globitel.task.management.system.core.user.factory.response;

import com.globitel.task.management.system.core.user.entity.embedded.UserRole;

public record UserUpdatedResponse(
        String userUuid,
        String email,
        String name,
        UserRole role
) {
}
