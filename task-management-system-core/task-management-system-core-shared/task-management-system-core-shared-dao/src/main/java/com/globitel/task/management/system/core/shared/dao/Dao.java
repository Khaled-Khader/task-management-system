package com.globitel.task.management.system.core.shared.dao;

import com.globitel.task.management.system.core.shared.identity.Identity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identity,C extends Creator<T>,U extends Updater<T>> {
    T save(T entity);

    Optional<T> find(String uuid);

    List<T> findAll();

    C creator();

    U updater(T entity);

}
