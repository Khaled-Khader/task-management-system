package com.globitel.task.management.system.core.token.usecase.domain;

import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.validation.Validator;

public class DeniedTokensByUserUseCase extends ValidatorConsumerUseCase<UserIdentity> {
    private final TokenDao tokenDao;

    public DeniedTokensByUserUseCase(Validator validator, TokenDao tokenDao){
        super(validator);
        this.tokenDao=tokenDao;
    }

    @Override
    protected void doExecute(UserIdentity request) {
        tokenDao.deniedAllTokensByUserEntity(request);
    }
}
