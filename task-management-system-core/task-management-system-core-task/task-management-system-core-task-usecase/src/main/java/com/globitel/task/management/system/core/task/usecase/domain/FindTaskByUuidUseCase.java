package com.globitel.task.management.system.core.task.usecase.domain;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.task.usecase.error.TaskError;
import jakarta.validation.Validator;

public class FindTaskByUuidUseCase extends ValidatorFunctionalUseCase<TaskIdentity,String> {

    protected final TaskDao  taskDao;

    public FindTaskByUuidUseCase(Validator validator,TaskDao taskDao) {
        super(validator);
        this.taskDao=taskDao;
    }
    @Override
    protected TaskIdentity doExecute(String request) {
        return taskDao.find(request)
                .orElseThrow(()->new BadRequestException(TaskError.TASK_NOT_FOUND));
    }
}
