package com.globitel.task.management.system.core.task.jpa;

import com.globitel.task.management.system.core.task.dao.TaskCreator;
import com.globitel.task.management.system.core.task.entity.TaskEntity;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class TaskCreatorImpl implements TaskCreator {

    private String uuid= UUID.randomUUID().toString();
    private TaskStatus taskStatus;
    private UserEntity user;
    private LocalDate dueDate;
    private String title;
    private String description;

    @Override
    public TaskCreator uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public TaskCreator taskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    @Override
    public TaskCreator user(UserIdentity user) {
        this.user = (UserEntity) user;
        return this;
    }

    @Override
    public TaskCreator dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @Override
    public TaskCreator title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TaskCreator description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TaskIdentity create() {
        return new TaskEntity(
                uuid,
                Instant.now(),
                title,
                description,
                taskStatus,
                user,
                dueDate
        );
    }
}
