package com.globitel.task.management.system.core.task.jpa;

import com.globitel.task.management.system.core.task.entity.TaskEntity;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {


    @Transactional
    int deleteTaskByUuid(String uuid);

    List<TaskIdentity> findByUser(UserEntity user);
}
