package com.globitel.task.management.system.core.shared.identity;

import java.time.Instant;

public interface Identity {
    String getUuid();
    Instant getCreatedAt();
}
