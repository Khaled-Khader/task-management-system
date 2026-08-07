package com.globitel.task.management.system.core.task.entity;

import com.globitel.task.management.system.core.shared.entity.BaseEntity;
import com.globitel.task.management.system.core.task.entity.embedded.TaskStatus;
import com.globitel.task.management.system.core.task.identity.TaskIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class TaskEntity extends BaseEntity implements TaskIdentity {

    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private UserEntity user;
    @Column(nullable = false)
    private LocalDate dueDate;

    public TaskEntity(String uuid,Instant createdAt,String title,String description,TaskStatus taskStatus,UserEntity user,LocalDate dueDate) {
        super(uuid,createdAt);
        this.title=title;
        this.description=description;
        this.taskStatus=taskStatus;
        this.user=user;
        this.dueDate=dueDate;
    }
}
