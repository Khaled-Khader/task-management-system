package com.globitel.task.management.system.core.shared.usecase;

public abstract class ValidatorSupplierUseCase<RES> {

    public RES execute(){
        return doExecute();
    }
    protected abstract RES doExecute();
}
