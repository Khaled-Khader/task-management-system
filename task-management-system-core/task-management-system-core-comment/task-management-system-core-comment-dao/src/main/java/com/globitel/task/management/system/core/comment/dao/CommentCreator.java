package com.globitel.task.management.system.core.comment.dao;

import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.shared.dao.Creator;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface CommentCreator extends Creator<CommentIdentity> {

    CommentCreator uuid(String uuid);
    CommentCreator user(UserIdentity user);
    CommentCreator task(TaskIdentity task);
    CommentCreator comment(CommentIdentity comment);
    CommentCreator content(String content);
}
