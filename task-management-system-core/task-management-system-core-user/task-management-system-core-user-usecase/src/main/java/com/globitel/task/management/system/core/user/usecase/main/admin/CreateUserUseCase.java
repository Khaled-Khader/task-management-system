package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.exception.NotAcceptableException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.UserResponse;
import com.globitel.task.management.system.core.user.factory.request.CreateUserRequest;
import com.globitel.task.management.system.core.user.function.TMSPasswordEncoder;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class CreateUserUseCase extends ValidatorFunctionalUseCase<UserResponse, CreateUserRequest> {

    private final UserDao  userDao;
    private final TMSPasswordEncoder tmsPasswordEncoder;

    public CreateUserUseCase(Validator validator,UserDao userDao,TMSPasswordEncoder tmsPasswordEncoder) {
        super(validator);
        this.userDao = userDao;
        this.tmsPasswordEncoder = tmsPasswordEncoder;
    }

    @Override
    protected UserResponse doExecute(CreateUserRequest request) {

        if(userDao.existByUsername(request.userName())){
            throw new NotAcceptableException(UserError.USER_NAME_EXISTS);
        }

        if(userDao.existByEmail(request.email())){
            throw new NotAcceptableException(UserError.USER_EMAIL_EXISTS);
        }

        String encodedPassword =tmsPasswordEncoder.encode(request.password());

        UserIdentity userIdentity=userDao.creator()
                .userName(request.userName())
                .userRole(request.role())
                .userStatus(request.status())
                .password(encodedPassword)
                .name(request.name())
                .email(request.email())
                .create();

        UserIdentity ignore=userDao.save(userIdentity);

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
