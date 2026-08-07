package com.globitel.task.management.system.core.task.usecase;

import com.globitel.task.management.system.core.comment.factory.domain.CommentUseCaseFactoryDomain;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;
import com.globitel.task.management.system.core.task.dao.TaskDao;
import com.globitel.task.management.system.core.task.factory.TaskUseCaseFactory;
import com.globitel.task.management.system.core.task.factory.request.*;
import com.globitel.task.management.system.core.task.factory.response.DeleteTaskResponse;
import com.globitel.task.management.system.core.task.factory.response.TaskDataResponse;
import com.globitel.task.management.system.core.task.factory.response.TaskResponse;
import com.globitel.task.management.system.core.task.usecase.main.admin.*;
import com.globitel.task.management.system.core.task.usecase.main.user.FindTasksForUserUseCase;
import com.globitel.task.management.system.core.task.usecase.main.user.UpdateStatusTaskForUserUseCase;
import com.globitel.task.management.system.core.task.usecase.main.user.ViewTaskDataByUserUseCase;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import jakarta.validation.Validator;

import java.util.List;

public class TaskUseCaseFactoryImpl implements TaskUseCaseFactory {

    private final CreateTaskUseCase createTaskUseCase;
    private final FindAllTasksUseCase findAllTasksUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final AssignTaskToUserUseCase assignTaskToUserUseCase;
    private final EditTaskDetailsUseCase editTaskDetailsUseCase;
    private final FindTasksForUserUseCase findTasksForUserUseCase;
    private final UpdateStatusTaskForUserUseCase updateStatusTaskForUserUseCase;
    private final ViewTaskDataByUserUseCase viewTaskDataByUserUseCase;
    public TaskUseCaseFactoryImpl(Validator validator, TaskDao taskDao, UserUseCaseFactoryDomain userUseCaseFactoryDomain, TMSSecurityContext tmSecurityContext, CommentUseCaseFactoryDomain commentUseCaseFactoryDomain) {
        this.createTaskUseCase = new CreateTaskUseCase(validator, taskDao, userUseCaseFactoryDomain);
        this.findAllTasksUseCase = new FindAllTasksUseCase(taskDao);
        this.deleteTaskUseCase = new DeleteTaskUseCase(validator, taskDao);
        this.assignTaskToUserUseCase = new AssignTaskToUserUseCase(validator, userUseCaseFactoryDomain, taskDao);
        this.editTaskDetailsUseCase = new EditTaskDetailsUseCase(validator, taskDao);
        this.findTasksForUserUseCase = new FindTasksForUserUseCase(taskDao, tmSecurityContext, userUseCaseFactoryDomain);
        this.updateStatusTaskForUserUseCase = new UpdateStatusTaskForUserUseCase(validator, taskDao, tmSecurityContext, userUseCaseFactoryDomain);
        this.viewTaskDataByUserUseCase=new ViewTaskDataByUserUseCase(validator,taskDao,commentUseCaseFactoryDomain,tmSecurityContext);
    }

    @Override
    public ValidatorFunctionalUseCase<TaskResponse, CreateTaskRequest> createTaskUseCase() {
        return createTaskUseCase;
    }

    @Override
    public ValidatorSupplierUseCase<List<TaskResponse>> findAllTasksUseCase() {
        return findAllTasksUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<DeleteTaskResponse, DeleteTaskRequest> deleteTaskUseCase() {
        return deleteTaskUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<TaskResponse, AssignTaskToUserRequest> assignTaskToUserUseCase() {
        return assignTaskToUserUseCase;
    }

    @Override
    public ValidatorSupplierUseCase<List<TaskResponse>> findTasksForUserUseCase() {
        return findTasksForUserUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<TaskResponse, UpdateTaskForUserRequest> updateTaskStatusForUserUseCase() {
        return updateStatusTaskForUserUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<TaskResponse, EditTaskDetailsRequest> editTaskDetailsUseCase() {
        return editTaskDetailsUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<TaskDataResponse, ViewTaskDataRequest> viewTaskDataUseCase() {
        return viewTaskDataByUserUseCase;
    }
}
