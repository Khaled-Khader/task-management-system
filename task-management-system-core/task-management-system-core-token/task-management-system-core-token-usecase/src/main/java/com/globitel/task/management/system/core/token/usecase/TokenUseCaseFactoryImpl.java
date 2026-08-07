package com.globitel.task.management.system.core.token.usecase;

import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.token.factory.TokenUseCaseFactory;
import com.globitel.task.management.system.core.token.function.TokenManager;
import com.globitel.task.management.system.core.token.usecase.main.ExtractUserUuidFromTokenUseCase;
import com.globitel.task.management.system.core.token.usecase.main.FindUserByTokenUuidUseCase;
import com.globitel.task.management.system.core.token.usecase.main.TokenValidationUseCase;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

public class TokenUseCaseFactoryImpl implements TokenUseCaseFactory {

    private final TokenValidationUseCase tokenValidationUseCase;
    private final FindUserByTokenUuidUseCase findUserByTokenUuidUseCase;
    private final ExtractUserUuidFromTokenUseCase extractUserUuidFromTokenUseCase;

    public TokenUseCaseFactoryImpl(
            TokenDao tokenDao,
            Validator validator,
            long duration,
            TokenManager tokenManager,
            UserUseCaseFactoryDomain userUseCaseFactoryDomain
    ) {
        tokenValidationUseCase = new TokenValidationUseCase(tokenDao, validator, duration, tokenManager,userUseCaseFactoryDomain);
        findUserByTokenUuidUseCase = new FindUserByTokenUuidUseCase(validator, tokenDao);
        extractUserUuidFromTokenUseCase = new ExtractUserUuidFromTokenUseCase(validator, tokenManager);
    }

    @Override
    public ValidatorConsumerUseCase<String> tokenValidationUseCase() {
        return tokenValidationUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase< UserIdentity,String> findUserByTokenUuidUseCase() {
        return findUserByTokenUuidUseCase;
    }

    @Override
    public ValidatorFunctionalUseCase<String, String> extractUserUuidFromTokenUseCase() {
        return extractUserUuidFromTokenUseCase;
    }
}
