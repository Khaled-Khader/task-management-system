package com.globitel.task.management.system.presentation.spring.boot.controller.activity.log;

import com.globitel.task.management.system.core.activitylog.factory.ActivityLogUseCaseFactory;
import com.globitel.task.management.system.core.activitylog.factory.response.ActivityLogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogUseCaseFactory aActivityLogUseCaseFactory;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<ActivityLogResponse> findAllActivityLog() {
        return aActivityLogUseCaseFactory.findAllActivityLog().execute();
    }
}
