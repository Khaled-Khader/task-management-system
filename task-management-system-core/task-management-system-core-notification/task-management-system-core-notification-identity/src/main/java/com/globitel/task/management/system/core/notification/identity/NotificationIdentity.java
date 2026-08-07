package com.globitel.task.management.system.core.notification.identity;

import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface NotificationIdentity extends Identity {

    String getAction();
    String getTitle();
    String getMessage();
    UserIdentity getUser();
    boolean isRead();
}
