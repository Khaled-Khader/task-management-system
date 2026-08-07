package com.globitel.task.management.system.core.token.factory.domain.request;


import com.globitel.task.management.system.core.user.identity.UserIdentity;

public record CreateTokenRequest(
        UserIdentity userIdentity
) {
}
