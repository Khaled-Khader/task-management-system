package com.globitel.task.management.system.core.task.usecase.main.admin;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.request.AssignTaskToUserRequest;
import com.globitel.task.management.system.core.task.factory.response.TaskResponse;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.task.usecase.error.TaskError;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

public class AssignTaskToUserUseCase  extends ValidatorFunctionalUseCase<TaskResponse, AssignTaskToUserRequest> {

    private final TaskDao taskDao;
    private final UserUseCaseFactoryDomain  userUseCaseFactoryDomain;

    public AssignTaskToUserUseCase(Validator validator, UserUseCaseFactoryDomain userUseCaseFactoryDomain,TaskDao taskDao) {
        super(validator);
        this.userUseCaseFactoryDomain = userUseCaseFactoryDomain;
        this.taskDao = taskDao;
    }

    @Override
    protected TaskResponse doExecute(AssignTaskToUserRequest request) {

        UserIdentity userIdentity=userUseCaseFactoryDomain.findUserByIdUseCase()
                .execute(request.userUuid());

        TaskIdentity taskIdentity=taskDao.find(request.taskUuid())
                .orElseThrow(()->new BadRequestException(TaskError.TASK_NOT_FOUND));

        TaskIdentity updatedTask=taskDao.updater(taskIdentity)
                .user(userIdentity)
                .update();

        TaskIdentity savedTask=taskDao.save(updatedTask);

        return new TaskResponse(
                savedTask.getUuid(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getUser().getUuid(),
                savedTask.getUser().getName(),
                savedTask.getDueDate(),
                savedTask.getTaskStatus()
        );
    }
}
