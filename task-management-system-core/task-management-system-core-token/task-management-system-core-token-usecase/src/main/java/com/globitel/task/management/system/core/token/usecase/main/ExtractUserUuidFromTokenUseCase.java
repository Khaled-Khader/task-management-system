package com.globitel.task.management.system.core.token.usecase.main;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.token.function.TokenManager;
import jakarta.validation.Validator;

public class ExtractUserUuidFromTokenUseCase extends ValidatorFunctionalUseCase<String,String> {

    private final TokenManager  tokenManager;
    public ExtractUserUuidFromTokenUseCase(Validator validator, TokenManager tokenManager) {
        super(validator);
        this.tokenManager = tokenManager;
    }

    @Override
    protected String doExecute(String request) {
        return tokenManager.extractData(request).userId();
    }
}
