package com.globitel.task.management.system.core.notification.dao;

import com.globitel.task.management.system.core.notification.identity.NotificationIdentity;
import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface NotificationCreator extends Creator<NotificationIdentity> {
    NotificationCreator uuid(String uuid);
    NotificationCreator action(String action);
    NotificationCreator message(String message);
    NotificationCreator title(String title);
    NotificationCreator user(UserIdentity user);
    NotificationCreator isRead(boolean isRead);

}
