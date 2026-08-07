package com.globitel.task.management.system.core.user.factory.response;

import java.util.List;

public record UserSecurityResponse(
        String userName,
        String password,
        List<String> userRoles
) {
}
