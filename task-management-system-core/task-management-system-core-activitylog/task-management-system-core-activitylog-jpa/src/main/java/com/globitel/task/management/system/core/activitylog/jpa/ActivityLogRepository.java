package com.globitel.task.management.system.core.activitylog.jpa;

import com.globitel.task.management.system.core.activitylog.entity.ActivityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLogEntity, String> {
}
