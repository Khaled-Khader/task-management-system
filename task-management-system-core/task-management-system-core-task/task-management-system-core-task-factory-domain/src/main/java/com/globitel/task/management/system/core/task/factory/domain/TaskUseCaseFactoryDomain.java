package com.globitel.task.management.system.core.task.factory.domain;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;

public interface TaskUseCaseFactoryDomain {
    ValidatorFunctionalUseCase<TaskIdentity,String> findTaskByUuidUseCase();
}
