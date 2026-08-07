package com.globitel.task.management.system.core.activitylog.identity;

import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;

public interface ActivityLogIdentity extends Identity {

    String getAction();
    Instant getTimestamp();
    UserIdentity getUser();
}
