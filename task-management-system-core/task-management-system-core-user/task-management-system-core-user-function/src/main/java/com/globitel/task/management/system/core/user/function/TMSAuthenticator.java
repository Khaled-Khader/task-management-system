package com.globitel.task.management.system.core.user.function;

import com.globitel.task.management.system.core.user.function.response.AuthenticatedUserResponse;

public interface TMSAuthenticator {
    AuthenticatedUserResponse authenticate(String username, String password);
}
