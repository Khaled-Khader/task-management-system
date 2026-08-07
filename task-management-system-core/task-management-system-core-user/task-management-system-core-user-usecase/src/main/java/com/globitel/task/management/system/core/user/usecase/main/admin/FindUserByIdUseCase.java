package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.UserResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class FindUserByIdUseCase extends ValidatorFunctionalUseCase<UserResponse,String> {
    private final UserDao userDao;

    public FindUserByIdUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }
    @Override
    protected UserResponse doExecute(String request) {
        UserIdentity userIdentity= userDao.find(request)
                .orElseThrow(() -> new BadRequestException(UserError.USER_NOT_FOUND));

        return new UserResponse(
                userIdentity.getUuid(),
                userIdentity.getName(),
                userIdentity.getUserName(),
                userIdentity.getEmail(),
                userIdentity.getUserStatus(),
                userIdentity.getUserRole()
        );
    }
}
