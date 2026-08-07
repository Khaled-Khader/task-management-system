package com.globitel.task.management.system.core.user.usecase.main;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.exception.UnAuthorizedException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.factory.domain.TokenUseCaseFactoryDomain;
import com.globitel.task.management.system.core.token.factory.domain.request.CreateTokenRequest;
import com.globitel.task.management.system.core.token.factory.domain.response.CreateTokenResponse;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.security.request.LoginRequest;
import com.globitel.task.management.system.core.user.factory.security.response.LoginResponse;
import com.globitel.task.management.system.core.user.function.TMSAuthenticator;
import com.globitel.task.management.system.core.user.function.response.AuthenticatedUserResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import jakarta.validation.Validator;


public class LoginUseCase extends ValidatorFunctionalUseCase<LoginResponse, LoginRequest> {

    private final UserDao userDao;
    private final TMSAuthenticator authenticator;
    private final TokenUseCaseFactoryDomain tokenUseCaseFactoryDomain;

    public LoginUseCase(Validator validator, TMSAuthenticator authenticator, UserDao userDao, TokenUseCaseFactoryDomain tokenUseCaseFactoryDomain) {
        super(validator);
        this.authenticator = authenticator;
        this.userDao = userDao;
        this.tokenUseCaseFactoryDomain = tokenUseCaseFactoryDomain;
    }


    @Override
    protected LoginResponse doExecute(LoginRequest request) {

        AuthenticatedUserResponse userSecurityResponse = authenticator.authenticate(request.userName(), request.password());


        UserIdentity userIdentity = userDao.findByUsername(userSecurityResponse.userName())
                .orElseThrow(() -> new BadRequestException(UserError.USER_NOT_FOUND));

    if(userIdentity.getUserStatus().name().equals("INACTIVE")){
        throw new UnAuthorizedException(UserError.USER_NOT_ACTIVE);
    }
        CreateTokenResponse createTokenResponse = tokenUseCaseFactoryDomain.createTokenUseCase().execute(new CreateTokenRequest(userIdentity));


        return new LoginResponse(
                createTokenResponse.token(),
                userIdentity.getUuid(),
                userIdentity.getName(),
                userIdentity.getUserName(),
                userIdentity.getEmail(),
                userIdentity.getUserStatus(),
                userIdentity.getUserRole()
        );
    }
}
