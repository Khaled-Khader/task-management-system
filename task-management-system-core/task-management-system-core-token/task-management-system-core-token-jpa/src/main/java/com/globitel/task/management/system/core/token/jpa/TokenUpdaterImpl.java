package com.globitel.task.management.system.core.token.jpa;

import com.globitel.task.management.system.core.token.dao.TokenUpdater;
import com.globitel.task.management.system.core.token.entity.TokenEntity;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
public class TokenUpdaterImpl implements TokenUpdater {

    private final TokenEntity tokenEntity;


    @Override
    public TokenUpdater tokenStatus(TokenStatus tokenStatus) {
        tokenEntity.setTokenStatus(tokenStatus);
        return this;
    }

    @Override
    public TokenUpdater lastUsed() {
        tokenEntity.setLastUsed(Instant.now());
        return this;
    }


    @Override
    public TokenIdentity update() {
        return tokenEntity;
    }

}
