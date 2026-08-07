package com.globitel.task.management.system.core.user.factory.response;


import com.globitel.task.management.system.core.user.entity.embedded.UserRole;

public record ViewUserDataResponse(
        String name,
        String email,
        UserRole role
) {
}
