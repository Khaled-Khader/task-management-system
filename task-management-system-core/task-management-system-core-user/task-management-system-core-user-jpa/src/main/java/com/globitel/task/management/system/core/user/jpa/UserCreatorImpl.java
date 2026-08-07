package com.globitel.task.management.system.core.user.jpa;

import com.globitel.task.management.system.core.user.dao.UserCreator;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.time.Instant;
import java.util.UUID;

public class UserCreatorImpl implements UserCreator {

    private String uuid= UUID.randomUUID().toString();
    private UserStatus userStatus;
    private UserRole userRole;
    private String name;
    private String email;
    private String password;
    private String userName;

    @Override
    public UserCreator uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public UserCreator name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserCreator userName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public UserCreator email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserCreator password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserCreator userRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public UserCreator userStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    @Override
    public UserIdentity create() {

        return new UserEntity(
                this.uuid,
                Instant.now(),
                this.name,
                this.userName,
                this.email,
                this.password,
                this.userRole,
                this.userStatus
        );
    }
}
