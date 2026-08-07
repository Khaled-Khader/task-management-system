package com.globitel.task.management.system.core.token.jpa;


import com.globitel.task.management.system.core.token.dao.TokenCreator;
import com.globitel.task.management.system.core.token.entity.TokenEntity;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.util.UUID;

public class TokenCreatorImpl implements TokenCreator {

    private String uuid = UUID.randomUUID().toString();
    private UserIdentity userIdentity;

    @Override
    public TokenCreator uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public TokenCreator user(UserIdentity userIdentity) {
        this.userIdentity=userIdentity;
        return this;
    }

    @Override
    public TokenIdentity create() {
        return new TokenEntity(
                uuid,
                (UserEntity) userIdentity,
                TokenStatus.ACTIVE,
                Instant.now(),
                Instant.now()
        );
    }
}
