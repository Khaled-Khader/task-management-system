package com.globitel.task.management.system.core.user.dao;

import com.globitel.task.management.system.core.shared.dao.Dao;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<UserIdentity,UserCreator,UserUpdater> {
    boolean existByUsername(String username);
    boolean existByEmail(String email);
    int deleteByUserName(String username);
    List<UserIdentity> findAllByUserRole(UserRole userRole);
    List<UserIdentity> findAllByUserStatus(UserStatus userStatus);
    List<UserIdentity> findAllByName(String name);
    Optional<UserIdentity> findByUsername(String username);

}
