package com.globitel.task.management.system.presentation.spring.boot.security;

import com.globitel.task.management.system.core.user.factory.response.UserSecurityResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class TMSUserDetails implements UserDetails {

    private final UserSecurityResponse userSecurityResponse;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userSecurityResponse.userRoles().stream()
                .map(role -> (GrantedAuthority) () -> "ROLE_" + role)
                .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return userSecurityResponse.password();
    }

    @Override
    public String getUsername() {
        return userSecurityResponse.userName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
