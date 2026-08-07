package com.globitel.task.management.system.core.notification.entity;

import com.globitel.task.management.system.core.notification.identity.NotificationIdentity;
import com.globitel.task.management.system.core.shared.entity.BaseEntity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "notifications")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotificationEntity extends BaseEntity implements NotificationIdentity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String message;
    @Column
    private boolean isRead;
    @ManyToOne
    @JoinColumn(name = "user_uuid" ,nullable = false)
    private UserEntity user;
    @Column
    private String action;

    public NotificationEntity(String uuid, Instant createdAt,String title,String message,boolean isRead,UserEntity user,String action) {
        super(uuid, createdAt);
        this.title = title;
        this.message = message;
        this.isRead = isRead;
        this.user = user;
        this.action = action;
    }
}
