package com.globitel.task.management.system.core.user.usecase;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.domain.CheckUserStatusUseCase;
import com.globitel.task.management.system.core.user.usecase.domain.FindUserByIdUseCase;
import com.globitel.task.management.system.core.user.usecase.domain.FindUserByUserNameUseCase;
import jakarta.validation.Validator;

public class UserUseCaseFactoryDomainImpl implements UserUseCaseFactoryDomain {

    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindUserByUserNameUseCase findUserByUserNameUseCase;
    private final CheckUserStatusUseCase checkUserStatusUseCase;

    public UserUseCaseFactoryDomainImpl(Validator validator, UserDao  userDao) {
        this.findUserByIdUseCase=new FindUserByIdUseCase(validator,userDao);
        this.findUserByUserNameUseCase=new FindUserByUserNameUseCase(validator,userDao);
        this.checkUserStatusUseCase=new CheckUserStatusUseCase(validator,userDao);
    }

    @Override
    public ValidatorFunctionalUseCase<UserIdentity, String> findUserByUsernameUseCase() {
        return findUserByUserNameUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<UserIdentity, String> findUserByIdUseCase() {
        return findUserByIdUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<Boolean, String> checkUserStatusUseCase() {
        return checkUserStatusUseCase;
    }
}
