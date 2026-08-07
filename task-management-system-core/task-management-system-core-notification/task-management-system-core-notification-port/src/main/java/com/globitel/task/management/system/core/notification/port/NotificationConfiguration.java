package com.globitel.task.management.system.core.notification.port;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.globitel.task.management.system.core.notification.entity")
public class NotificationConfiguration {
}
