package com.globitel.task.management.system.core.comment.dao;

import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.shared.dao.Updater;

public interface CommentUpdater extends Updater<CommentIdentity> {

    @Override
    default CommentIdentity update() {
        throw new UnsupportedOperationException("CommentUpdater ");
    }
}
