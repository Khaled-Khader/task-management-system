package com.globitel.task.management.system.core.user.function.response;

public record AuthenticatedUserResponse(
        String [] roles,
        String userName
) {
}
