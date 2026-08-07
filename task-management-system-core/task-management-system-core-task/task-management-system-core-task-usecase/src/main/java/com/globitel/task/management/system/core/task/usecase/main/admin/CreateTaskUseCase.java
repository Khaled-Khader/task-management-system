package com.globitel.task.management.system.core.task.usecase.main.admin;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.factory.request.CreateTaskRequest;
import com.globitel.task.management.system.core.task.factory.response.TaskResponse;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

public class CreateTaskUseCase extends ValidatorFunctionalUseCase<TaskResponse, CreateTaskRequest> {

    private final TaskDao  taskDao;
    private final UserUseCaseFactoryDomain userUseCaseFactoryDomain;

    public CreateTaskUseCase(Validator validator, TaskDao taskDao, UserUseCaseFactoryDomain userUseCaseFactoryDomain) {
        super(validator);
        this.taskDao = taskDao;
        this.userUseCaseFactoryDomain = userUseCaseFactoryDomain;
    }

    @Override
    protected TaskResponse doExecute(CreateTaskRequest request) {


        UserIdentity userIdentity= userUseCaseFactoryDomain.findUserByIdUseCase()
                .execute(request.userUuid());


        TaskIdentity taskIdentity=taskDao.creator()
                .title(request.title())
                .description(request.description())
                .taskStatus(TaskStatus.PENDING)
                .dueDate(request.dueDate())
                .user(userIdentity)
                .create();

        TaskIdentity ignore=taskDao.save(taskIdentity);

        return new TaskResponse(
                taskIdentity.getUuid(),
                taskIdentity.getTitle(),
                taskIdentity.getDescription(),
                taskIdentity.getUser().getUuid(),
                taskIdentity.getUser().getName(),
                taskIdentity.getDueDate(),
                taskIdentity.getTaskStatus()
        );
    }
}
