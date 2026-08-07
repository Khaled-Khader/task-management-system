package com.globitel.task.management.system.core.user.jpa;

import com.globitel.task.management.system.core.user.dao.UserUpdater;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUpdaterImpl implements UserUpdater {
    private final UserEntity userEntity;
    @Override
    public UserUpdater name(String name) {
        if(name==null){
            return this;
        }
        this.userEntity.setName(name);
        return this;
    }

    @Override
    public UserUpdater userName(String userName) {
        if(userName==null){
            return this;
        }
        this.userEntity.setUserName(userName);
        return this;
    }

    @Override
    public UserUpdater email(String email) {
        if(email==null){
            return this;
        }
        this.userEntity.setEmail(email);
        return this;
    }

    @Override
    public UserUpdater password(String password) {
        if(password==null){
            return this;
        }
        this.userEntity.setPassword(password);
        return this;
    }

    @Override
    public UserUpdater userRole(UserRole userRole) {
        if(userRole==null){
            return this;
        }
        this.userEntity.setUserRole(userRole);
        return this;
    }

    @Override
    public UserUpdater userStatus(UserStatus userStatus) {
        if(userStatus==null){
            return this;
        }
        this.userEntity.setUserStatus(userStatus);
        return this;
    }

    @Override
    public UserIdentity update() {
        return this.userEntity;
    }
}
