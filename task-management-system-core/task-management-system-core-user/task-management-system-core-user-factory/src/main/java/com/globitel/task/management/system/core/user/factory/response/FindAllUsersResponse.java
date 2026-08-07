package com.globitel.task.management.system.core.user.factory.response;

import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;

public record FindAllUsersResponse(
        String uuid,
        String name,
        String userName,
        String email,
        UserRole role,
        UserStatus status

) {
}
