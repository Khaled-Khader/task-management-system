package com.globitel.task.management.system.core.comment.jpa;

import com.globitel.task.management.system.core.comment.entity.CommentEntity;
import com.globitel.task.management.system.core.comment.identity.CommentIdentity;
import com.globitel.task.management.system.core.task.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
    Optional<CommentIdentity> findByUuid(String uuid);

    List<CommentEntity> findByTask(TaskEntity task);
}
