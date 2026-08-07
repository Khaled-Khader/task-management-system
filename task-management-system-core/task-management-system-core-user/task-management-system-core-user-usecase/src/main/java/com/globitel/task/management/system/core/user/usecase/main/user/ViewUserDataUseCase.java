package com.globitel.task.management.system.core.user.usecase.main.user;

import com.globitel.task.management.system.core.shared.exception.BadRequestException;
import com.globitel.task.management.system.core.shared.security.context.TMSSecurityContext;
import com.globitel.task.management.system.core.shared.usecase.ValidatorSupplierUseCase;
import com.globitel.task.management.system.core.user.dao.UserDao;
import com.globitel.task.management.system.core.user.factory.response.ViewUserDataResponse;
import com.globitel.task.management.system.core.user.identity.UserIdentity;
import com.globitel.task.management.system.core.user.usecase.error.UserError;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewUserDataUseCase extends ValidatorSupplierUseCase<ViewUserDataResponse> {

    private final UserDao userDao;
    private final TMSSecurityContext  tmsSecurityContext;

    @Override
    protected ViewUserDataResponse doExecute() {

        String userName= tmsSecurityContext.getCurrentUserUserName();

        UserIdentity userIdentity=userDao.findByUsername(userName)
                .orElseThrow(()->new BadRequestException(UserError.USER_NOT_FOUND));

        return new ViewUserDataResponse(
                userIdentity.getName(),
                userIdentity.getEmail(),
                userIdentity.getUserRole()
        );
    }
}
