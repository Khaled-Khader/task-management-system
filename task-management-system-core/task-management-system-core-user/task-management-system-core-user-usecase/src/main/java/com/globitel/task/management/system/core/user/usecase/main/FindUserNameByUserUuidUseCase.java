package com.globitel.task.management.system.core.user.usecase.main;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class FindUserNameByUserUuidUseCase extends ValidatorFunctionalUseCase<String,String> {

    private final UserDao  userDao;

    public FindUserNameByUserUuidUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }

    @Override
    protected String doExecute(String request) {
        return userDao.find(request).orElseThrow(
                ()->new BadRequestException(UserError.USER_NOT_FOUND)
        ).getUserName();
    }
}
