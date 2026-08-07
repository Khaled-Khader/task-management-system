package com.globitel.task.management.system.core.task.factory.request;


import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        String userUuid ,
        LocalDate dueDate

) {
}
