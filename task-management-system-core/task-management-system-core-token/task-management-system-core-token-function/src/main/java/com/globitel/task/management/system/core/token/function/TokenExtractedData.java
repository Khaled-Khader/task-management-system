package com.globitel.task.management.system.core.token.function;

public record TokenExtractedData(
        String userId,
        String tokenId,
        String [] types
) {
}
