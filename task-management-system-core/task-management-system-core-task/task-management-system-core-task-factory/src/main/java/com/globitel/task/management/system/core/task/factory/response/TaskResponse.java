package com.globitel.task.management.system.core.task.factory.response;

import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;

import java.time.LocalDate;

public record TaskResponse(
        String uuid,
        String title,
        String description,
        String userUuid,
        String username,
        LocalDate dueDate,
        TaskStatus taskStatus
) {
}
