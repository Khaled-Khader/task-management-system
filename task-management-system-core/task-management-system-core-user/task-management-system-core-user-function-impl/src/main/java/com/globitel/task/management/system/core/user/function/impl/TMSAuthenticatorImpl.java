package com.globitel.task.management.system.core.user.function.impl;

import com.globitel.task.management.system.core.shared.exception.UnAuthorizedException;
import com.globitel.task.management.system.core.shared.exception.data.DefaultErrorMessage;
import com.globitel.task.management.system.core.user.function.TMSAuthenticator;
import com.globitel.task.management.system.core.user.function.response.AuthenticatedUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@RequiredArgsConstructor
public class TMSAuthenticatorImpl implements TMSAuthenticator {

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticatedUserResponse authenticate(String username, String password) {

        Authentication authentication;
        try{
            authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    password
                            )
                    );
        }catch(Exception e){
            throw new UnAuthorizedException(DefaultErrorMessage.of("AUTHENTICATION_FAILED", "TMS-USER-UC-DF-1000"));
        }


        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        assert userDetails != null;

        return new  AuthenticatedUserResponse(
                userDetails.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .toArray(String[]::new),
                userDetails.getUsername()
        );
    }
}
