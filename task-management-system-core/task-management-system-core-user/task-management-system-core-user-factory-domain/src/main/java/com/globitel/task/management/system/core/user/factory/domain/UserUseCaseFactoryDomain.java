package com.globitel.task.management.system.core.user.factory.domain;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface UserUseCaseFactoryDomain {

    ValidatorFunctionalUseCase<UserIdentity,String> findUserByUsernameUseCase();
    ValidatorFunctionalUseCase<UserIdentity,String> findUserByIdUseCase();
    ValidatorFunctionalUseCase<Boolean,String> checkUserStatusUseCase();
}
