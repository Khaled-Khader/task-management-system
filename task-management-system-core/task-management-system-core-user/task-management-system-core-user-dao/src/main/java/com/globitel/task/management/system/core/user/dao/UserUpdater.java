package com.globitel.task.management.system.core.user.dao;

import com.globitel.task.management.system.core.shared.dao.Updater;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface UserUpdater extends Updater<UserIdentity> {
    UserUpdater name(String name);
    UserUpdater userName(String userName);
    UserUpdater email(String email);
    UserUpdater password(String password);
    UserUpdater userRole(UserRole userRole);
    UserUpdater userStatus(UserStatus userStatus);
}
