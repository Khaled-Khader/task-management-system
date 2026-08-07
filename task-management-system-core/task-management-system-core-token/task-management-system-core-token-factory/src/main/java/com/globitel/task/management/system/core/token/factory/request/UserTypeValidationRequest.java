package com.globitel.task.management.system.core.token.factory.request;


import com.globitel.task.management.system.core.user.entity.embedded.UserRole;

public record UserTypeValidationRequest(
        String token,
        UserRole role
) {
}
