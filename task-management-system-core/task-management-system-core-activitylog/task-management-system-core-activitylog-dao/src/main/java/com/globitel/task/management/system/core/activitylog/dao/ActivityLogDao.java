package com.globitel.task.management.system.core.activitylog.dao;

import com.globitel.task.management.system.core.activitylog.identity.ActivityLogIdentity;
import com.globitel.task.management.system.core.shared.dao.Dao;

public interface ActivityLogDao extends Dao<ActivityLogIdentity,ActivityLogCreator,ActivityLogUpdater> {

}
