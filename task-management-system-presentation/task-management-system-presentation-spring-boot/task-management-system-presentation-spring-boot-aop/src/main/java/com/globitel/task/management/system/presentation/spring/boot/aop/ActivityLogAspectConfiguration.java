package com.globitel.task.management.system.presentation.spring.boot.aop;

import com.globitel.task.management.system.core.activitylog.factory.ActivityLogUseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ActivityLogAspectConfiguration {

    @Bean
    public ActivityLogAspect activityLogAspect(ActivityLogUseCaseFactory activityLogUseCaseFactory) {
        return new ActivityLogAspect(activityLogUseCaseFactory);
    }
}
