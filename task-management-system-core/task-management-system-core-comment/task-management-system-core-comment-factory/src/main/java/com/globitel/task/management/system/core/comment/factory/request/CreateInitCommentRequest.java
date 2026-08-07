package com.globitel.task.management.system.core.comment.factory.request;

public record CreateInitCommentRequest(
        String content,
        String taskUuid
) {
}
