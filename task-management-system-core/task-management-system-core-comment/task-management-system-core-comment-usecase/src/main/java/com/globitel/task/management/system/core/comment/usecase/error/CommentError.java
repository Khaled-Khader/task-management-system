package com.globitel.task.management.system.core.comment.usecase.error;

import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommentError implements ErrorMessage {

    COMMENT_NOT_FOUND("TMS-CMNT-UC-1000","comment not found"),
    TASK_NOT_OWNED_BY_USER("TMS-CMNT-UC-2000","task not for this user to comment")
    ;

    private final String code;
    private final String message;
}
