package com.globitel.task.management.system.core.task.usecase.main.admin;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.request.EditTaskDetailsRequest;
import com.globitel.task.management.system.core.task.factory.response.TaskResponse;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.task.usecase.error.TaskError;
import jakarta.validation.Validator;

public class EditTaskDetailsUseCase extends ValidatorFunctionalUseCase<TaskResponse, EditTaskDetailsRequest> {

    private final TaskDao  taskDao;

    public EditTaskDetailsUseCase(Validator validator, TaskDao taskDao) {
        super(validator);
        this.taskDao = taskDao;
    }

    @Override
    protected TaskResponse doExecute(EditTaskDetailsRequest request) {

        TaskIdentity taskIdentity=taskDao.find(request.uuid())
                .orElseThrow(()->new BadRequestException(TaskError.TASK_NOT_FOUND));

        TaskIdentity updatedTask=taskDao.updater(taskIdentity)
                .title(request.title())
                .description(request.description())
                .taskStatus(request.status())
                .dueDate(request.dueDate())
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
