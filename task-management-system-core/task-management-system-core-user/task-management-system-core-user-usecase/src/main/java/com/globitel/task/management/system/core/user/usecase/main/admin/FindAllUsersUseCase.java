package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.FindAllUsersResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;

import java.util.List;

public class FindAllUsersUseCase extends ValidatorSupplierUseCase<List<FindAllUsersResponse>> {

    private final UserDao userDao;

    public FindAllUsersUseCase(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    protected List<FindAllUsersResponse> doExecute() {
        List<UserIdentity> userIdentities = userDao.findAll();
        return userIdentities.stream().map(userIdentity -> new FindAllUsersResponse(
                userIdentity.getUuid(),
                userIdentity.getName(),
                userIdentity.getUserName(),
                userIdentity.getEmail(),
                userIdentity.getUserRole(),
                userIdentity.getUserStatus()
        )).toList();
    }
}
