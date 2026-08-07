package com.globitel.task.management.system.core.comment.factory;

import com.globitel.task.management.system.core.comment.factory.request.CreateInitCommentRequest;
import com.globitel.task.management.system.core.comment.factory.request.CreateReplyCommentRequest;
import com.globitel.task.management.system.core.comment.factory.response.CommentResponse;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;

public interface CommentUseCaseFactory {

    ValidatorFunctionalUseCase<CommentResponse, CreateInitCommentRequest> createInitCommentByAdminUseCase();

    ValidatorFunctionalUseCase<CommentResponse, CreateReplyCommentRequest> createReplyCommentByAdminUseCase();

    ValidatorFunctionalUseCase<CommentResponse, CreateInitCommentRequest> createInitCommentByUserUseCase();

    ValidatorFunctionalUseCase<CommentResponse, CreateReplyCommentRequest> createReplyCommentByUserUseCase();
}
