package com.globitel.task.management.system.core.task.identity;

import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.time.LocalDate;

public interface TaskIdentity extends Identity {
    String getTitle();
    String getDescription();
    TaskStatus getTaskStatus();
    LocalDate getDueDate();
    UserIdentity getUser();

}
