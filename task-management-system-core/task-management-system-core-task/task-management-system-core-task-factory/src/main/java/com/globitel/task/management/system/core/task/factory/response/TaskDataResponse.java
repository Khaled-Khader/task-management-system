package com.globitel.task.management.system.core.task.factory.response;


import com.globitel.task.management.system.core.comment.factory.response.CommentResponse;

import java.util.List;

public record TaskDataResponse(
        TaskResponse taskResponse,
        List<CommentResponse> commentResponses
) {
}
