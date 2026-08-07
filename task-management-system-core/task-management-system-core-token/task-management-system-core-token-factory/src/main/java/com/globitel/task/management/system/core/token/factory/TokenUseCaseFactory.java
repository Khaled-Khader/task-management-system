package com.globitel.task.management.system.core.token.factory;


import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.factory.request.UserTypeValidationRequest;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface TokenUseCaseFactory {
    ValidatorConsumerUseCase<String> tokenValidationUseCase();

    ValidatorFunctionalUseCase<UserIdentity, String> findUserByTokenUuidUseCase();



    ValidatorFunctionalUseCase<String,String>extractUserUuidFromTokenUseCase();
}
