package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.request.EditUserDetailsRequest;
import com.globitel.task.management.system.core.user.factory.response.UserResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;

public class EditUserDetailsUseCase extends ValidatorFunctionalUseCase<UserResponse, EditUserDetailsRequest> {

    private final UserDao userDao;

    public EditUserDetailsUseCase(Validator  validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }

    @Override
    protected UserResponse doExecute(EditUserDetailsRequest request) {

        if(request.userName()!=null && userDao.existByUsername(request.userName())){
            throw new BadRequestException(UserError.USER_NAME_EXISTS);
        }

        if(request.email()!=null && userDao.existByEmail(request.email())){
            throw new BadRequestException(UserError.USER_EMAIL_EXISTS);
        }

        UserIdentity userIdentity=userDao.find(request.uuid())
                .orElseThrow(()->new BadRequestException(UserError.USER_NOT_FOUND));

        UserIdentity updatedUser=userDao.updater(userIdentity)
                .userName(request.userName())
                .name(request.name())
                .email(request.email())
                .userRole(request.role())
                .userStatus(request.status())
                .update();

        UserIdentity  savedUser=userDao.save(updatedUser);

        return new UserResponse(
                savedUser.getUuid(),
                savedUser.getName(),
                savedUser.getUserName(),
                savedUser.getEmail(),
                savedUser.getUserStatus(),
                savedUser.getUserRole()
        );
    }
}
