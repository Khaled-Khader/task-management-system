package com.globitel.task.management.system.core.task.factory.request;

import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;

import java.time.LocalDate;

public record EditTaskDetailsRequest(
        String uuid,
        String title,
        String description,
        TaskStatus status,
        LocalDate dueDate
) {
}
