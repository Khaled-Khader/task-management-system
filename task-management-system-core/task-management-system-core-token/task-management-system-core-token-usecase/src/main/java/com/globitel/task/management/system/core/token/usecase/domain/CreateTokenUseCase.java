package com.globitel.task.management.system.core.token.usecase.domain;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.token.factory.domain.request.CreateTokenRequest;
import com.globitel.task.management.system.core.token.factory.domain.response.CreateTokenResponse;
import com.globitel.task.management.system.core.token.function.TokenManager;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import jakarta.validation.Validator;

public class CreateTokenUseCase extends ValidatorFunctionalUseCase< CreateTokenResponse,CreateTokenRequest> {

    private final TokenDao tokenDao;
    private final TokenManager tokenManager;

    public CreateTokenUseCase(Validator validator, TokenDao tokenDao, TokenManager tokenManager) {
        super(validator);
        this.tokenDao = tokenDao;
        this.tokenManager=tokenManager;
    }

    @Override
    protected CreateTokenResponse doExecute(CreateTokenRequest request) {

        TokenIdentity tokenIdentity = tokenDao.creator()
                .user(request.userIdentity())
                .create();

        String token =tokenManager.generateToken(tokenIdentity);

        tokenDao.save(tokenIdentity);
        tokenDao.updateOutOfRangeTokens();

        return new CreateTokenResponse(token);
    }
}
