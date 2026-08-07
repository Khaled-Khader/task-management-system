package com.globitel.task.management.system.core.user.entity;

import com.globitel.task.management.system.core.shared.entity.BaseEntity;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity implements UserIdentity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    public UserEntity(String uuid, Instant createdAt, String name, String userName, String email, String password, UserRole userRole, UserStatus userStatus) {
        super(uuid, createdAt);
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

}
