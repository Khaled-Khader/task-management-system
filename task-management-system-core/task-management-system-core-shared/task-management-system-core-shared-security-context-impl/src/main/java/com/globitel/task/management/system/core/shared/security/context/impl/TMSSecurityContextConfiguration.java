package com.globitel.task.management.system.core.shared.security.context.impl;

import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TMSSecurityContextConfiguration {

    @Bean
    public TMSSecurityContext tmsSecurityContext() {
        return new TMSSecurityContextImpl();
    }
}
