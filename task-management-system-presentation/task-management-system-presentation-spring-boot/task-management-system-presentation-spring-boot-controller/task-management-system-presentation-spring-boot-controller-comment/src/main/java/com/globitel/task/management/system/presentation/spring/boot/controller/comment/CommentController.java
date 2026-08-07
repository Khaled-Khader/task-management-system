package com.globitel.task.management.system.presentation.spring.boot.controller.comment;

import com.globitel.task.management.system.core.comment.factory.CommentUseCaseFactory;
import com.globitel.task.management.system.core.comment.factory.request.CreateInitCommentRequest;
import com.globitel.task.management.system.core.comment.factory.request.CreateReplyCommentRequest;
import com.globitel.task.management.system.core.comment.factory.response.CommentResponse;
import com.globitel.task.management.system.presentation.spring.boot.aop.ActivityLog;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentUseCaseFactory commentUseCaseFactory;

    @ActivityLog("ADMIN CREATE COMMENT")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin/init")
    public CommentResponse createInitCommentForAdmin(@RequestBody CreateInitCommentRequest createInitCommentRequest) {
        return commentUseCaseFactory.createInitCommentByAdminUseCase().execute(createInitCommentRequest);
    }

    @ActivityLog("ADMIN CREATE REPLY COMMENT")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin/reply")
    public CommentResponse createReplyCommentForAdmin(@RequestBody CreateReplyCommentRequest createReplyCommentRequest) {
        return commentUseCaseFactory.createReplyCommentByAdminUseCase().execute(createReplyCommentRequest);
    }

    @ActivityLog("USER CREATE COMMENT")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("user/init")
    public CommentResponse createInitCommentForUser(@RequestBody CreateInitCommentRequest createInitCommentRequest) {
        return commentUseCaseFactory.createInitCommentByUserUseCase().execute(createInitCommentRequest);
    }

    @ActivityLog("USER CREATE REPLY COMMENT")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("user/reply")
    public CommentResponse createReplyCommentForUser(@RequestBody CreateReplyCommentRequest createReplyCommentRequest) {
        return commentUseCaseFactory.createReplyCommentByUserUseCase().execute(createReplyCommentRequest);
    }


}
