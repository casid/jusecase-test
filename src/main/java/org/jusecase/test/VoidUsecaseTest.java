package org.jusecase.test;

import org.jusecase.VoidUsecase;

public abstract class VoidUsecaseTest<Request> extends UsecaseTestInterface<Request> {
    protected VoidUsecase<Request> usecase;

    protected void whenRequestIsExecuted() {
        usecase.execute(request);
    }
}
