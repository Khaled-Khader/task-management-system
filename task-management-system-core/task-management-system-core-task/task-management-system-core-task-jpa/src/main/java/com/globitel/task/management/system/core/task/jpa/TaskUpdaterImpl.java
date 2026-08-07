package com.globitel.task.management.system.core.task.jpa;

import com.globitel.task.management.system.core.task.dao.TaskUpdater;
import com.globitel.task.management.system.core.task.entity.TaskEntity;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class TaskUpdaterImpl implements TaskUpdater {

    private final TaskEntity taskEntity;

    @Override
    public TaskUpdater taskStatus(TaskStatus taskStatus) {
        if(taskStatus==null){
            return this;
        }
        taskEntity.setTaskStatus(taskStatus);
        return this;
    }

    @Override
    public TaskUpdater user(UserIdentity user) {
        if(user==null){
            return this;
        }
        this.taskEntity.setUser((UserEntity) user);
        return this;
    }

    @Override
    public TaskUpdater dueDate(LocalDate dueDate) {
        if(dueDate==null){
            return this;
        }
        taskEntity.setDueDate(dueDate);
        return this;
    }

    @Override
    public TaskUpdater title(String title) {
        if(title==null){
            return this;
        }
        taskEntity.setTitle(title);
        return this;
    }

    @Override
    public TaskUpdater description(String description) {
        if(description==null){
            return this;
        }
        taskEntity.setDescription(description);
        return this;
    }

    @Override
    public TaskIdentity update() {
        return taskEntity;
    }
}
