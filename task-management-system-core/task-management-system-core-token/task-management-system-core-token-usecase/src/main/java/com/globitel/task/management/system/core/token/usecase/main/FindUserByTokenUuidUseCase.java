package com.globitel.task.management.system.core.token.usecase.main;
import com.globitel.task.management.system.core.shared.exception.UnAuthorizedException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import com.globitel.task.management.system.core.token.usecase.error.TokenErrors;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

import java.util.Optional;

public class FindUserByTokenUuidUseCase extends ValidatorFunctionalUseCase< UserIdentity,String> {

    private final TokenDao tokenDao;

    public FindUserByTokenUuidUseCase(Validator validator, TokenDao tokenDao) {
        super(validator);
        this.tokenDao = tokenDao;
    }

    @Override
    protected UserIdentity doExecute(String request) {
        Optional<TokenIdentity> tokenIdentity = Optional.of(tokenDao.find(request)
                .orElseThrow(() -> new UnAuthorizedException(TokenErrors.TOKEN_NOT_FOUND)));

        return tokenIdentity.get().getUser();
    }
}
