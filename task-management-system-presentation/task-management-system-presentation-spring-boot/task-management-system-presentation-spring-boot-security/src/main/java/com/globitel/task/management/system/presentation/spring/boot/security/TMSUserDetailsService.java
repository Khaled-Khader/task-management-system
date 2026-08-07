package com.globitel.task.management.system.presentation.spring.boot.security;

import com.globitel.task.management.system.core.user.factory.UserUseCaseFactory;
import com.globitel.task.management.system.core.user.factory.response.UserSecurityResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class TMSUserDetailsService implements UserDetailsService {

    private final UserUseCaseFactory userUseCaseFactory;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurityResponse userSecurityResponse = userUseCaseFactory.findUserByUserNameForSecurityUseCase().execute(username);
        if (userSecurityResponse == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new TMSUserDetails(userSecurityResponse);
    }
}
