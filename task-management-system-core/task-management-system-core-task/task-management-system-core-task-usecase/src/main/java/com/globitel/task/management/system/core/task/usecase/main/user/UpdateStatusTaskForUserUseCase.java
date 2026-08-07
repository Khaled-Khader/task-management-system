package com.globitel.task.management.system.core.task.usecase.main.user;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.exception.data.DefaultErrorMessage;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.request.UpdateTaskForUserRequest;
import com.globitel.task.management.system.core.task.factory.response.TaskResponse;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.task.usecase.error.TaskError;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;


public class UpdateStatusTaskForUserUseCase extends ValidatorFunctionalUseCase<TaskResponse, UpdateTaskForUserRequest> {

    private final TaskDao taskDao;
    private final TMSSecurityContext tmSecurityContext;
    private final UserUseCaseFactoryDomain userUseCaseFactoryDomain;

    public UpdateStatusTaskForUserUseCase(Validator validator, TaskDao taskDao, TMSSecurityContext tmSecurityContext, UserUseCaseFactoryDomain userUseCaseFactoryDomain) {
        super(validator);
        this.taskDao = taskDao;
        this.tmSecurityContext = tmSecurityContext;
        this.userUseCaseFactoryDomain = userUseCaseFactoryDomain;
    }

    @Override
    protected TaskResponse doExecute(UpdateTaskForUserRequest updateTaskRequest) {

        TaskIdentity taskIdentity = taskDao.find(updateTaskRequest.taskUuid())
                .orElseThrow(() -> new BadRequestException(TaskError.TASK_NOT_FOUND));

        String userName = tmSecurityContext.getCurrentUserUserName();
        UserIdentity userIdentity = userUseCaseFactoryDomain.findUserByUsernameUseCase().execute(userName);

        if (!userIdentity.getUuid().equals(taskIdentity.getUser().getUuid())) {
            throw new BadRequestException(DefaultErrorMessage.of("task is not for this user", "TMS-TSK-UC-DF-2000"));
        }

        TaskIdentity updatedTask = taskDao.updater(taskIdentity)
                .taskStatus(updateTaskRequest.taskStatus())
                .update();

        TaskIdentity savedTask = taskDao.save(updatedTask);


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
