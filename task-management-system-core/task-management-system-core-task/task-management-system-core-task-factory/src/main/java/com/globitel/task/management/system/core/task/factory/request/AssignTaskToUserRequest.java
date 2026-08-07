package com.globitel.task.management.system.core.task.factory.request;

public record AssignTaskToUserRequest(
        String userUuid,
        String taskUuid
) {
}
