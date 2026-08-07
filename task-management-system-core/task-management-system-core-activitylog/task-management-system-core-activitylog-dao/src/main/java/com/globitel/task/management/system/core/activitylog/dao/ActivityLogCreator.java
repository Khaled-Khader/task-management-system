package com.globitel.task.management.system.core.activitylog.dao;

import com.globitel.task.management.system.core.activitylog.identity.ActivityLogIdentity;
import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;

public interface ActivityLogCreator extends Creator<ActivityLogIdentity> {

    ActivityLogCreator uuid(String uuid);
    ActivityLogCreator user(UserIdentity  user);
    ActivityLogCreator action(String action);
    ActivityLogCreator timestamp(Instant  timestamp);
}
