package com.globitel.task.management.system.core.user.factory.security.request;

public record LoginRequest(
        String userName,
        String password
) {
}
