package com.globitel.task.management.system.core.user.factory.request;

import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EditUserDetailsRequest(
        String uuid,
        String name,
        String userName,
        String email,
        UserRole role,
        UserStatus status
) {
}
