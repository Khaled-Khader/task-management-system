package com.globitel.task.management.system.core.activitylog.factory;

import com.globitel.task.management.system.core.activitylog.factory.request.CreateActivityLogRequest;
import com.globitel.task.management.system.core.activitylog.factory.response.ActivityLogResponse;
import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;

import java.util.List;

public interface ActivityLogUseCaseFactory {
    ValidatorConsumerUseCase<CreateActivityLogRequest> createActivityLogUseCase();

    ValidatorSupplierUseCase<List<ActivityLogResponse>>  findAllActivityLog();
}
