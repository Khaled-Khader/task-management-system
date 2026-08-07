package com.globitel.task.management.system.core.activitylog.dao;

import com.globitel.task.management.system.core.activitylog.identity.ActivityLogIdentity;
import com.globitel.task.management.system.core.shared.dao.Updater;

public interface ActivityLogUpdater extends Updater<ActivityLogIdentity> {
    @Override
    default ActivityLogIdentity update() {
        throw new UnsupportedOperationException(" ActivityLogUpdater Not supported yet.");
    }
}
