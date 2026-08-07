package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.request.DeleteUserByUserNameRequest;
import com.globitel.task.management.system.core.user.factory.response.DeleteUserByUserNameResponse;
import jakarta.validation.Validator;

public class DeleteUserByUserNameUseCase extends ValidatorFunctionalUseCase<DeleteUserByUserNameResponse, DeleteUserByUserNameRequest> {

    private final UserDao  userDao;

    public DeleteUserByUserNameUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }

    @Override
    protected DeleteUserByUserNameResponse doExecute(DeleteUserByUserNameRequest request) {
        return new DeleteUserByUserNameResponse(userDao.deleteByUserName(request.userName()));
    }
}
