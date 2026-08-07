package com.globitel.task.management.system.core.comment.factory.request;

public record CreateReplyCommentRequest(
        String content,
        String taskUuid,
        String parentCommentUuid
) {
}
