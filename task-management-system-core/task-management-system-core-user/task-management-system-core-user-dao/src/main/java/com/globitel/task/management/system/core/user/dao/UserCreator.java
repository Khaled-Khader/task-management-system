package com.globitel.task.management.system.core.user.dao;

import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface UserCreator extends Creator<UserIdentity> {
    UserCreator uuid(String uuid);
    UserCreator name(String name);
    UserCreator userName(String userName);
    UserCreator email(String email);
    UserCreator password(String password);
    UserCreator userRole(UserRole  userRole);
    UserCreator userStatus(UserStatus userStatus);
}
