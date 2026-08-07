package com.globitel.task.management.system.core.user.jpa;

import com.globitel.task.management.system.core.user.dao.UserCreator;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.dao.UserUpdater;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import com.globitel.task.management.system.core.user.entity.embedded.UserRole;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class UserJpa implements UserDao {
    private final UserRepository userRepository;

    @Override
    public UserIdentity save(UserIdentity entity) {
        return userRepository.save((UserEntity)entity);
    }

    @Override
    public Optional<UserIdentity> find(String uuid) {
        return userRepository.findById(uuid).map(Function.identity());
    }

    @Override
    public List<UserIdentity> findAll() {
        return List.copyOf(userRepository.findAll());
    }

    @Override
    public UserCreator creator() {
        return new UserCreatorImpl();
    }

    @Override
    public UserUpdater updater(UserIdentity entity) {
        return new UserUpdaterImpl((UserEntity) entity);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public int deleteByUserName(String username) {
        return userRepository.deleteByUserName(username);
    }

    @Override
    public List<UserIdentity> findAllByUserRole(UserRole userRole) {
        return List.copyOf(userRepository.findAllByUserRole(userRole));
    }

    @Override
    public List<UserIdentity> findAllByUserStatus(UserStatus userStatus) {
        return List.copyOf(userRepository.findAllByUserStatus(userStatus));
    }

    @Override
    public List<UserIdentity> findAllByName(String name) {
        return List.copyOf(userRepository.findAllByName(name));
    }

    @Override
    public Optional<UserIdentity> findByUsername(String username) {
        return userRepository.findByUserName(username).map(Function.identity());
    }
}
