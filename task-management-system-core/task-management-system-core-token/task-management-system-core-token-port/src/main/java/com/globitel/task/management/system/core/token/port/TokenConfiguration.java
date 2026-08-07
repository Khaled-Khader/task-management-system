package com.globitel.task.management.system.core.token.port;

import com.globitel.task.management.system.core.token.dao.TokenDao;
import com.globitel.task.management.system.core.token.factory.TokenUseCaseFactory;
import com.globitel.task.management.system.core.token.factory.domain.TokenUseCaseFactoryDomain;
import com.globitel.task.management.system.core.token.function.TokenManager;
import com.globitel.task.management.system.core.token.function.impl.TokenManagerImpl;
import com.globitel.task.management.system.core.token.jpa.TokenJpa;
import com.globitel.task.management.system.core.token.jpa.TokenRepository;
import com.globitel.task.management.system.core.token.usecase.TokenUseCaseFactoryDomainImpl;
import com.globitel.task.management.system.core.token.usecase.TokenUseCaseFactoryImpl;
import com.globitel.task.management.system.core.user.factory.domain.UserUseCaseFactoryDomain;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.globitel.task.management.system.core.token.jpa")
@EntityScan(basePackages = "com.globitel.task.management.system.core.token.entity")
public class TokenConfiguration {


    @Bean
    public TokenDao tokenDao(TokenRepository tokenRepository, @Value("${NUMBER.OF.ACTIVE.TOKENS}") int range) {
        return new TokenJpa(tokenRepository, range);
    }


    @Bean
    public TokenUseCaseFactoryDomain tokenUseCaseFactoryDomain(TokenDao tokenDao, Validator validator, TokenManager tokenManager) {
        return new TokenUseCaseFactoryDomainImpl(tokenDao, validator, tokenManager);
    }

    @Bean
    public TokenUseCaseFactory tokenUseCaseFactory(TokenDao tokenDao, Validator validator, TokenManager tokenManager, @Value("${EXPIRED.TIME.DURATION}") long duration, UserUseCaseFactoryDomain userUseCaseFactoryDomain) {
        return new TokenUseCaseFactoryImpl(tokenDao, validator, duration, tokenManager,userUseCaseFactoryDomain);
    }

    @Bean
    public TokenManager tokenManager(@Value("JWT.SECRET") String secret, @Value("${TOKEN.EXPIRED.TIME}") long tokenExpiredTime) {
        return new TokenManagerImpl(tokenExpiredTime, secret);
    }
}
