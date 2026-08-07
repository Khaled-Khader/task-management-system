package com.globitel.task.management.system.core.activitylog.usecase.main;

import com.globitel.task.management.system.core.activitylog.dao.ActivityLogDao;
import com.globitel.task.management.system.core.activitylog.factory.request.CreateActivityLogRequest;
import com.globitel.task.management.system.core.activitylog.identity.ActivityLogIdentity;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

import java.time.Instant;

public class CreateActivityLogUseCase extends ValidatorConsumerUseCase<CreateActivityLogRequest> {

    private final ActivityLogDao  activityLogDao;
    private final TMSSecurityContext tmsSecurityContext;
    private final UserUseCaseFactoryDomain userUseCaseFactoryDomain;
    public CreateActivityLogUseCase(Validator validator,ActivityLogDao activityLogDao, TMSSecurityContext tmsSecurityContext,UserUseCaseFactoryDomain userUseCaseFactoryDomain ) {
        super(validator);
        this.activityLogDao = activityLogDao;
        this.tmsSecurityContext = tmsSecurityContext;
        this.userUseCaseFactoryDomain = userUseCaseFactoryDomain;
    }

    @Override
    protected void doExecute(CreateActivityLogRequest request) {

        String userName= tmsSecurityContext.getCurrentUserUserName();

        UserIdentity userIdentity=userUseCaseFactoryDomain.findUserByUsernameUseCase().execute(userName);

        ActivityLogIdentity activityLogIdentity=activityLogDao.creator()
                .user(userIdentity)
                .action(userIdentity.getUserName() +" made a "+request.action())
                .timestamp(Instant.now())
                .create();

        activityLogDao.save(activityLogIdentity);
    }
}
