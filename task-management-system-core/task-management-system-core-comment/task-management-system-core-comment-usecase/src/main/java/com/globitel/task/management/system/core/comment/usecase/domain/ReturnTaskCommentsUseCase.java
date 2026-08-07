package com.globitel.task.management.system.core.comment.usecase.domain;

import com.globitel.task.management.system.core.comment.dao.CommentDao;
import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import jakarta.validation.Validator;

import java.util.List;

public class ReturnTaskCommentsUseCase extends ValidatorFunctionalUseCase<List<CommentIdentity>, TaskIdentity> {

    private final CommentDao commentDao;

    public ReturnTaskCommentsUseCase(Validator validator, CommentDao commentDao) {
        super(validator);
        this.commentDao = commentDao;
    }

    @Override
    protected List<CommentIdentity> doExecute(TaskIdentity taskIdentity) {
        return commentDao.findCommentsByTaskIdentity(taskIdentity);
    }
}
