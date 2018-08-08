package org.jusecase.test;

import org.jusecase.executors.AbstractUsecaseExecutor;
import org.jusecase.executors.UsecaseRequestResolver;

public abstract class UsecaseExecutorTest {
    protected AbstractUsecaseExecutor executor;
    protected UsecaseRequestResolver requestResolver = new UsecaseRequestResolver();

    public void givenExecutor(AbstractUsecaseExecutor executor) {
        this.executor = executor;
    }

    public void thenUsecaseCanBeExecuted(Class<?> usecaseClass) {
        Class<?> requestClass = requestResolver.getRequestClass(usecaseClass);
        thenUsecaseCanBeExecuted(requestClass, usecaseClass);
    }

    public void thenUsecaseCanBeExecuted(Class<?> requestClass, Class<?> usecaseClass) {
        Object usecase = executor.getUsecase(requestClass);
        assertUsecaseMatches(requestClass, usecaseClass, usecase);
    }

    protected abstract void assertUsecaseMatches(Class<?> requestClass, Class<?> usecaseClass, Object usecase);
}
