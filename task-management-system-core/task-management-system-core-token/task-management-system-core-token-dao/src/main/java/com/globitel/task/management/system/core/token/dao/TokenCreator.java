package com.globitel.task.management.system.core.token.dao;

import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface TokenCreator extends Creator<TokenIdentity> {

    TokenCreator uuid(String uuid);

    TokenCreator user(UserIdentity userIdentity);
}
