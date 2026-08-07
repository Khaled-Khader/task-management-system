package com.globitel.task.management.system.core.token.dao;

import com.globitel.task.management.system.core.shared.dao.Updater;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;

public interface TokenUpdater extends Updater<TokenIdentity> {
    TokenUpdater tokenStatus(TokenStatus tokenStatus);

    TokenUpdater lastUsed();
}
