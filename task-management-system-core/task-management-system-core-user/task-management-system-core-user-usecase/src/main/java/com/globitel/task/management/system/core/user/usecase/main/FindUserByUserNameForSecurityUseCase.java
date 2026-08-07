package com.globitel.task.management.system.core.user.usecase.main;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.UserSecurityResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.Collections;

public class FindUserByUserNameForSecurityUseCase extends ValidatorFunctionalUseCase<UserSecurityResponse, String> {

    private final UserDao userDao;
    public FindUserByUserNameForSecurityUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }

    @Override
    protected UserSecurityResponse doExecute(String request) {
        UserIdentity userIdentity = userDao.findByUsername(request)
                .orElseThrow(() -> new BadRequestException(UserError.USER_NOT_FOUND));
        return new UserSecurityResponse(
                userIdentity.getUserName(),
                userIdentity.getPassword(),
                new ArrayList<>(Collections.singleton(userIdentity.getUserRole().name()))
        );
    }
}
