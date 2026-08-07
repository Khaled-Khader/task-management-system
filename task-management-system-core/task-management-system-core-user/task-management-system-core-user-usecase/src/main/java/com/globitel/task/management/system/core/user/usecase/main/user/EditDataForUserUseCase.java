package com.globitel.task.management.system.core.user.usecase.main.user;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.exception.NotAcceptableException;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.request.EditDataForUserRequest;
import com.globitel.task.management.system.core.user.factory.response.UserUpdatedResponse;
import com.globitel.task.management.system.core.user.function.TMSPasswordEncoder;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class EditDataForUserUseCase extends ValidatorFunctionalUseCase<UserUpdatedResponse, EditDataForUserRequest> {

    private final UserDao userDao;
    private final TMSSecurityContext tmSecurityContext;
    private final TMSPasswordEncoder  tmsPasswordEncoder;

    public EditDataForUserUseCase(Validator validator, UserDao userDao, TMSSecurityContext tmSecurityContext, TMSPasswordEncoder tmsPasswordEncoder) {
        super(validator);
        this.userDao = userDao;
        this.tmSecurityContext = tmSecurityContext;
        this.tmsPasswordEncoder = tmsPasswordEncoder;
    }

    @Override
    protected UserUpdatedResponse doExecute(EditDataForUserRequest request) {

        if (userDao.existByEmail(request.email())) {
            throw new NotAcceptableException(UserError.USER_EMAIL_EXISTS);
        }

        String userName = tmSecurityContext.getCurrentUserUserName();

        UserIdentity userIdentity = userDao.findByUsername(userName)
                .orElseThrow(() -> new BadRequestException(UserError.USER_NOT_FOUND));

        UserIdentity updatedUser = userDao.updater(userIdentity)
                .email(request.email())
                .name(request.name())
                .password(tmsPasswordEncoder.encode(request.password()))
                .update();

        UserIdentity ignore=userDao.save(updatedUser);


        return new UserUpdatedResponse(
                updatedUser.getUuid(),
                updatedUser.getEmail(),
                updatedUser.getName(),
                updatedUser.getUserRole()
        );

    }
}
