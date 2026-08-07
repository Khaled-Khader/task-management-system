package com.globitel.task.management.system.core.token.identity;


import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;

public interface TokenIdentity extends Identity {
    UserIdentity getUser();

    TokenStatus getTokenStatus();

    Instant getLastUsed();
}