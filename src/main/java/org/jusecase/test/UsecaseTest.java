package org.jusecase.test;

import org.jusecase.Usecase;

public abstract class UsecaseTest<Request, Response> extends UsecaseTestInterface<Request> {
    protected Usecase<Request, Response> usecase;
    protected Response response;

    protected void whenRequestIsExecuted() {
        response = usecase.execute(request);
    }

    protected abstract void thenResponseIs(Response expected);

    protected abstract void thenResponseIsNotNull();
}
