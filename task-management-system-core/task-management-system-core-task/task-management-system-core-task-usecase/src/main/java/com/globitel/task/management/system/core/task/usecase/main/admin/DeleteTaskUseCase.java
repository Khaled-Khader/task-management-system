package com.globitel.task.management.system.core.task.usecase.main.admin;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.request.DeleteTaskRequest;
import com.globitel.task.management.system.core.task.factory.response.DeleteTaskResponse;
import jakarta.validation.Validator;

public class DeleteTaskUseCase extends ValidatorFunctionalUseCase<DeleteTaskResponse, DeleteTaskRequest> {

    private final TaskDao taskDao;

    public DeleteTaskUseCase(Validator validator,TaskDao taskDao) {
        super(validator);
        this.taskDao = taskDao;
    }

    @Override
    protected DeleteTaskResponse doExecute(DeleteTaskRequest request) {
        return new DeleteTaskResponse(taskDao.deleteTask(request.uuid()));
    }
}
