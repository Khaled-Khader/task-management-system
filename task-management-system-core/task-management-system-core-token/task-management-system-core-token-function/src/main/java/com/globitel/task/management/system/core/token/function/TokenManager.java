package com.globitel.task.management.system.core.token.function;

import com.globitel.task.management.system.core.token.identity.TokenIdentity;

public interface TokenManager {
    String generateToken(TokenIdentity tokenIdentity);

    boolean validateToken(String token);

    TokenExtractedData extractData(String token);
}
