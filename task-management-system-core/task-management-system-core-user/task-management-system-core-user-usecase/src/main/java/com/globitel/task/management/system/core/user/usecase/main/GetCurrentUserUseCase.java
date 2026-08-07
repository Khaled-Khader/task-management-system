package com.globitel.task.management.system.core.user.usecase.main;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.UserResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetCurrentUserUseCase extends ValidatorSupplierUseCase<UserResponse> {

    private final TMSSecurityContext tmsSecurityContext;
    private final UserDao userDao;

    @Override
    protected UserResponse doExecute() {
        String userName = tmsSecurityContext.getCurrentUserUserName();
        UserIdentity userIdentity = userDao.findByUsername(userName)
                .orElseThrow(() -> new BadRequestException(UserError.USER_NOT_FOUND));

        return new UserResponse(
                userIdentity.getUuid(),
                userIdentity.getName(),
                userIdentity.getUserName(),
                userIdentity.getEmail(),
                userIdentity.getUserStatus(),
                userIdentity.getUserRole()
        );
    }
}
