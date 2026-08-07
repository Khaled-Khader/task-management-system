package com.globitel.task.management.system.core.notification.dao;

import com.globitel.task.management.system.core.notification.identity.NotificationIdentity;
import com.globitel.task.management.system.core.shared.dao.Updater;

public interface NotificationUpdater extends Updater<NotificationIdentity> {

    @Override
    default NotificationIdentity update(){
        throw new UnsupportedOperationException("NotificationUpdater Not supported yet.");
    }
}
