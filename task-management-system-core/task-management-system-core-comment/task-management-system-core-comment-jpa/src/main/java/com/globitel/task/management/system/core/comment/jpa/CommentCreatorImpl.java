package com.globitel.task.management.system.core.comment.jpa;

import com.globitel.task.management.system.core.comment.dao.CommentCreator;
import com.globitel.task.management.system.core.comment.entity.CommentEntity;
import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.task.entity.TaskEntity;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.util.UUID;

public class CommentCreatorImpl implements CommentCreator {

    private String uuid= UUID.randomUUID().toString();
    private UserEntity user;
    private TaskEntity task;
    private CommentEntity comment;
    private String content;

    @Override
    public CommentCreator uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public CommentCreator user(UserIdentity user) {
        this.user = (UserEntity) user;
        return this;
    }

    @Override
    public CommentCreator task(TaskIdentity task) {
        this.task = (TaskEntity) task;
        return this;
    }

    @Override
    public CommentCreator comment(CommentIdentity comment) {
        if(comment==null){
            return this;
        }
        this.comment = (CommentEntity) comment;
        return this;
    }

    @Override
    public CommentCreator content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public CommentIdentity create() {
        return new CommentEntity(
                this.uuid,
                Instant.now(),
                this.content,
                this.user,
                this.task,
                this.comment
        );
    }
}
