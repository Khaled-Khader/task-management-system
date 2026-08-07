package com.globitel.task.management.system.core.token.usecase.main;
import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.usecase.ValidatorConsumerUseCase;
import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.token.function.TokenExtractedData;
import com.globitel.task.management.system.core.token.function.TokenManager;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import com.globitel.task.management.system.core.token.usecase.error.TokenErrors;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import jakarta.validation.Validator;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;


public class TokenValidationUseCase extends ValidatorConsumerUseCase<String> {

    private final TokenDao tokenDao;
    private final long duration;
    private final TokenManager tokenManager;
    private final UserUseCaseFactoryDomain  userUseCaseFactoryDomain;

    public TokenValidationUseCase(TokenDao tokenDao, Validator validator, long duration, TokenManager tokenManager, UserUseCaseFactoryDomain userUseCaseFactoryDomain) {
        super(validator);
        this.tokenDao = tokenDao;
        this.duration = duration;
        this.tokenManager = tokenManager;
        this.userUseCaseFactoryDomain = userUseCaseFactoryDomain;
    }

    @Override
    protected void doExecute(String token) {

        boolean isVerified = tokenManager.validateToken(token);

        if (!isVerified) {
            throw  new RuntimeException("token not verified");
        }

         TokenExtractedData tokenExtractedData=tokenManager.extractData(token);

        if(!userUseCaseFactoryDomain.checkUserStatusUseCase().execute(tokenExtractedData.userId())){
            throw new RuntimeException("user inactive");
        }
        Optional<TokenIdentity> optionalTokenIdentity = Optional.of(tokenDao.find(tokenExtractedData.tokenId())
                .orElseThrow(() -> new BadRequestException(TokenErrors.TOKEN_NOT_FOUND)));

        TokenIdentity tokenIdentity = optionalTokenIdentity.get();

        if (tokenIdentity.getTokenStatus().toString().equals("DENIED")) {
            throw new RuntimeException("token denied");
        }

        if (tokenIdentity.getLastUsed().plus(Duration.ofMinutes(duration)).isBefore(Instant.now())) {
            tokenIdentity = tokenDao.updater(tokenIdentity)
                    .tokenStatus(TokenStatus.DENIED)
                    .update();

            tokenDao.save(tokenIdentity);
            throw new RuntimeException("token refresh is over");
        } else {
            tokenIdentity = tokenDao.updater(tokenIdentity)
                    .lastUsed()
                    .update();
            tokenDao.save(tokenIdentity);
        }

    }
}
