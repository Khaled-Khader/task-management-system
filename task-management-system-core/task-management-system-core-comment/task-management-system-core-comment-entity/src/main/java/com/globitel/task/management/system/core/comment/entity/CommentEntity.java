package com.globitel.task.management.system.core.comment.entity;

import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.shared.entity.BaseEntity;
import com.globitel.task.management.system.core.task.entity.TaskEntity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "comments")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentEntity extends BaseEntity implements CommentIdentity {

    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_Uuid",nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "task_uuid",nullable = false)
    private TaskEntity task;
    @ManyToOne
    @JoinColumn(name = "replayed_comment_uuid")
    private CommentEntity replayedComment;

    public CommentEntity(String uuid, Instant createdAt , String content, UserEntity user, TaskEntity task, CommentEntity replayedComment) {
        super(uuid, createdAt);
        this.content = content;
        this.user = user;
        this.task = task;
        this.replayedComment = replayedComment;
    }

}
