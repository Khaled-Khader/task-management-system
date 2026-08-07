package com.globitel.task.management.system.presentation.spring.boot.aop;

import com.globitel.task.management.system.core.activitylog.factory.ActivityLogUseCaseFactory;
import com.globitel.task.management.system.core.activitylog.factory.request.CreateActivityLogRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final ActivityLogUseCaseFactory  activityLogUseCaseFactory;

    @AfterReturning(value = "@annotation(activityLog)", argNames = "activityLog")
    public void afterReturning(ActivityLog activityLog) {
        CreateActivityLogRequest createActivityLogRequest=new CreateActivityLogRequest(activityLog.value());
        activityLogUseCaseFactory.createActivityLogUseCase().execute(createActivityLogRequest);
    }
}
