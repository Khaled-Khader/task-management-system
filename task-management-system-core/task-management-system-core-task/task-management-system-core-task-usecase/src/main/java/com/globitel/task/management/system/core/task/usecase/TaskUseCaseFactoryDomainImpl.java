package com.globitel.task.management.system.core.task.usecase;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.domain.TaskUseCaseFactoryDomain;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.task.usecase.domain.FindTaskByUuidUseCase;
import jakarta.validation.Validator;

public class TaskUseCaseFactoryDomainImpl implements TaskUseCaseFactoryDomain {

    private final FindTaskByUuidUseCase  findTaskByUuidUseCase;

    public TaskUseCaseFactoryDomainImpl(Validator validator, TaskDao  taskDao) {
        this.findTaskByUuidUseCase=new  FindTaskByUuidUseCase(validator,taskDao);
    }

    @Override
    public ValidatorFunctionalUseCase<TaskIdentity, String> findTaskByUuidUseCase() {
        return findTaskByUuidUseCase;
    }
}
