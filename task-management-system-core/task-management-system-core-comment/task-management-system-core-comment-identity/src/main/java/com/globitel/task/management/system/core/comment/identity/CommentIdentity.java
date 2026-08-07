package com.globitel.task.management.system.core.comment.identity;


import com.globitel.task.management.system.core.shared.identity.Identity;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

public interface CommentIdentity extends Identity {
    String getContent();
    TaskIdentity  getTask();
    UserIdentity  getUser();
    CommentIdentity getReplayedComment();
}
