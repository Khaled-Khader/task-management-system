package com.globitel.task.management.system.core.user.factory.response;

import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;

public record UserResponse(
        String uuid,
        String name,
        String userName,
        String email,
        UserStatus  status,
        UserRole role
) {
}
