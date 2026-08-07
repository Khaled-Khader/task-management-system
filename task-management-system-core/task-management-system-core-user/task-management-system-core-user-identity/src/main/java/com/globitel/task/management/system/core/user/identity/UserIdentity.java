package com.globitel.task.management.system.core.user.identity;

import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;

public interface UserIdentity extends Identity {

    String getName();
    String getUserName();
    String getEmail();
    String getPassword();
    UserRole getUserRole();
    UserStatus getUserStatus();
}
