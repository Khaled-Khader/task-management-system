package com.globitel.task.management.system.core.activitylog.jpa;

import com.globitel.task.management.system.core.activitylog.dao.ActivityLogCreator;
import com.globitel.task.management.system.core.activitylog.entity.ActivityLogEntity;
import com.globitel.task.management.system.core.activitylog.identity.ActivityLogIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.util.UUID;

public class ActivityLogCreatorImpl implements ActivityLogCreator {

    private String uuid= UUID.randomUUID().toString();
    private UserEntity user;
    private String action;
    private Instant  timestamp;


    @Override
    public ActivityLogCreator uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public ActivityLogCreator user(UserIdentity user) {
        this.user=(UserEntity)user;
        return this;
    }

    @Override
    public ActivityLogCreator action(String action) {
        this.action = action;
        return this;
    }

    @Override
    public ActivityLogCreator timestamp(Instant timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public ActivityLogIdentity create() {
        return new ActivityLogEntity(
                this.uuid,
                Instant.now(),
                this.action,
                this.timestamp,
                this.user
        );
    }
}
