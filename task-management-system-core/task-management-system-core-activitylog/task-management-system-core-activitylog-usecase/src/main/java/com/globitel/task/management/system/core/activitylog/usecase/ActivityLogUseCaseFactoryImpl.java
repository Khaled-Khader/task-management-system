package com.globitel.task.management.system.core.activitylog.usecase;

import com.globitel.task.management.system.core.activitylog.dao.ActivityLogDao;
import com.globitel.task.management.system.core.activitylog.factory.ActivityLogUseCaseFactory;
import com.globitel.task.management.system.core.activitylog.factory.request.CreateActivityLogRequest;
import com.globitel.task.management.system.core.activitylog.factory.response.ActivityLogResponse;
import com.globitel.task.management.system.core.activitylog.usecase.main.CreateActivityLogUseCase;
import com.globitel.task.management.system.core.activitylog.usecase.main.FindAllActivityLogUseCase;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import jakarta.validation.Validator;

import java.util.List;

public class ActivityLogUseCaseFactoryImpl implements ActivityLogUseCaseFactory {

    private final CreateActivityLogUseCase  createActivityLogUseCase;
    private final FindAllActivityLogUseCase findAllActivityLogUseCase;

    public ActivityLogUseCaseFactoryImpl(Validator validator, ActivityLogDao  activityLogDao, TMSSecurityContext tmsSecurityContext, UserUseCaseFactoryDomain userUseCaseFactoryDomain) {
        this.createActivityLogUseCase = new CreateActivityLogUseCase(validator, activityLogDao, tmsSecurityContext, userUseCaseFactoryDomain);
        this.findAllActivityLogUseCase = new FindAllActivityLogUseCase(activityLogDao);
    }


    @Override
    public ValidatorConsumerUseCase<CreateActivityLogRequest> createActivityLogUseCase() {
        return createActivityLogUseCase;
    }

    @Override
    public ValidatorSupplierUseCase<List<ActivityLogResponse>> findAllActivityLog() {
        return findAllActivityLogUseCase;
    }
}
