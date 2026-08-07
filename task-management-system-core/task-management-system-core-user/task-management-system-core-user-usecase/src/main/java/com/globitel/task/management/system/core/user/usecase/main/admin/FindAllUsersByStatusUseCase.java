package com.globitel.task.management.system.core.user.usecase.main.admin;

import com.globitel.task.management.system.core.shared.usecase.ValidatorFunctionalUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.entity.embedded.UserStatus;
import com.globitel.task.management.system.core.user.factory.request.FindAllUsersByRequest;
import com.globitel.task.management.system.core.user.factory.response.FindAllUsersResponse;
import jakarta.validation.Validator;

import java.util.List;

public class FindAllUsersByStatusUseCase extends ValidatorFunctionalUseCase<List<FindAllUsersResponse>, FindAllUsersByRequest> {
    private final UserDao userDao;

    public FindAllUsersByStatusUseCase(Validator validator, UserDao userDao) {
        super(validator);
        this.userDao = userDao;
    }

    @Override
    protected List<FindAllUsersResponse> doExecute(FindAllUsersByRequest request) {
        return userDao.findAllByUserStatus(UserStatus.valueOf(request.filter()))
                .stream()
                .map(user -> new FindAllUsersResponse(user.getUuid(), user.getName(), user.getUserName(), user.getEmail(), user.getUserRole(), user.getUserStatus()))
                .toList();
    }
}
