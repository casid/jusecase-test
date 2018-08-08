package org.jusecase.test;

import net.jodah.typetools.TypeResolver;

public abstract class UsecaseTestInterface<Request> {
    protected Request request;
    protected Throwable error;

    @SuppressWarnings("unchecked")
    public void createRequest() {
        try {
            Class<?> requestClass = TypeResolver.resolveRawArguments(UsecaseTestInterface.class, getClass())[0];
            request = (Request) requestClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate request. You need to override createRequest() and do it manually.", e);
        }
    }

    protected abstract void whenRequestIsExecuted();

    protected void whenErrorRequestIsExecuted() {
        try {
            whenRequestIsExecuted();
        } catch (Throwable e) {
            error = e;
        }
    }

    protected abstract void thenErrorIs(Throwable expected);

    protected abstract void thenErrorIs(Class<? extends Throwable> expected);

    protected abstract void thenErrorMessageIs(String expected);
}
