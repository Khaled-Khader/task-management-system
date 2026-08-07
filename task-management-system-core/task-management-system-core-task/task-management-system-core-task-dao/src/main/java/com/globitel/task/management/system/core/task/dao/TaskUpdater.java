package com.globitel.task.management.system.core.task.dao;

import com.globitel.task.management.system.core.shared.dao.Updater;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.time.LocalDate;

public interface TaskUpdater extends Updater<TaskIdentity> {

    TaskUpdater taskStatus(TaskStatus taskStatus);
    TaskUpdater user(UserIdentity user);
    TaskUpdater dueDate(LocalDate dueDate);
    TaskUpdater title(String title);
    TaskUpdater description(String description);
}
