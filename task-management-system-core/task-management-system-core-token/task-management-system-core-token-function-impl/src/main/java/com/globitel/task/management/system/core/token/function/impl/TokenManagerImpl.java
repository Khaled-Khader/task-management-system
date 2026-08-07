package com.globitel.task.management.system.core.token.function.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.globitel.task.management.system.core.token.function.TokenExtractedData;
import com.globitel.task.management.system.core.token.function.TokenManager;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;

import java.time.Duration;
import java.time.Instant;


public class TokenManagerImpl implements TokenManager {

    private final long duration;
    private final Algorithm algorithm;

    public TokenManagerImpl(long duration, String secret) {
        this.duration = duration;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    @Override
    public String generateToken(TokenIdentity tokenIdentity) {
        return  JWT.create()
                .withSubject(tokenIdentity.getUser().getUuid())
                .withIssuer("task-management-system")
                .withClaim("tokenId", tokenIdentity.getUuid())
                .withArrayClaim("roles", new String[]{tokenIdentity.getUser().getUserRole().toString()})
                .withExpiresAt(Instant.now().plus(Duration.ofHours(duration)))
                .sign(algorithm);
    }

    @Override
    public boolean validateToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withIssuer("task-management-system")
                .build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public TokenExtractedData extractData(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return new TokenExtractedData(
                decodedJWT.getSubject(),
                decodedJWT.getClaim("tokenId").asString(),
                decodedJWT.getClaim("roles").asArray(String.class)
        );
    }
}
