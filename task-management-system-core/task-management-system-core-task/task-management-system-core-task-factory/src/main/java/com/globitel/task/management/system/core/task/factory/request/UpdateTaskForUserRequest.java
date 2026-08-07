package com.globitel.task.management.system.core.task.factory.request;

import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;

public record UpdateTaskForUserRequest(
        String taskUuid,
        TaskStatus taskStatus
) {
}
