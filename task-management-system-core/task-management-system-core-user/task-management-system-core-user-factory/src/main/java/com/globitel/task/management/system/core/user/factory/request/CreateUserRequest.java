package com.globitel.task.management.system.core.user.factory.request;

import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;

public record CreateUserRequest(
        String name,
        String userName,
        String email,
        String password,
        UserRole role,
        UserStatus status
) {
}
