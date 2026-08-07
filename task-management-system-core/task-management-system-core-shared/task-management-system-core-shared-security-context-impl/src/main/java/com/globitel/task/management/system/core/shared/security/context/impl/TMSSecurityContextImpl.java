package com.globitel.task.management.system.core.shared.security.context.impl;

import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.user.factory.response.UserSecurityResponse;
import com.globitel.task.management.system.presentation.spring.boot.security.TMSUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TMSSecurityContextImpl implements TMSSecurityContext {

    @Override
    public String getCurrentUserUserName() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;

        TMSUserDetails userPrincipal =
                (TMSUserDetails) authentication.getPrincipal();

        assert userPrincipal != null;

        UserSecurityResponse userSecurityResponse
                =userPrincipal.getUserSecurityResponse();

        assert userSecurityResponse != null;

        return userSecurityResponse.userName();
    }
}
