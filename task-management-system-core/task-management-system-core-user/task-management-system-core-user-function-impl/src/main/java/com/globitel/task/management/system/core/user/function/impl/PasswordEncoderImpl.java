package com.globitel.task.management.system.core.user.function.impl;

import com.globitel.task.management.system.core.user.function.TMSPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PasswordEncoderImpl implements TMSPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
