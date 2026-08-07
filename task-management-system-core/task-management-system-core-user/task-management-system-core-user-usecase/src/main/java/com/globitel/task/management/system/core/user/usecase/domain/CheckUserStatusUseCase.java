package com.globitel.task.management.system.core.user.usecase.domain;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class CheckUserStatusUseCase extends ValidatorFunctionalUseCase<Boolean,String> {

    private final UserDao userDao;

    public CheckUserStatusUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao=userDao;
    }

    @Override
    protected Boolean doExecute(String request) {

        UserIdentity userIdentity=userDao.find(request)
                .orElseThrow(()->new BadRequestException(UserError.USER_NOT_FOUND));

        return userIdentity.getUserStatus().name().equals("ACTIVE");
    }
}
