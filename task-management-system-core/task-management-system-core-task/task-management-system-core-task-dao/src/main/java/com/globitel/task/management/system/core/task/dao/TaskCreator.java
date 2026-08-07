package com.globitel.task.management.system.core.task.dao;

import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.time.LocalDate;

public interface TaskCreator extends Creator<TaskIdentity> {

    TaskCreator uuid(String uuid);
    TaskCreator taskStatus(TaskStatus taskStatus);
    TaskCreator user(UserIdentity user);
    TaskCreator dueDate(LocalDate dueDate);
    TaskCreator title(String title);
    TaskCreator description(String description);

}
