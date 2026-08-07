package com.globitel.task.management.system.core.user.factory.request;

public record EditDataForUserRequest(
        String name,
        String email,
        String password
) {
}
