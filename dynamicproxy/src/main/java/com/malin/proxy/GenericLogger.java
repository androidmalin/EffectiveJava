package com.malin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * Here is a generic logger class
 */
public class GenericLogger implements InvocationHandler {

    private final Object target;

    public GenericLogger(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.println("Generic Logger Entry: Invoking " + m.getName());
        return m.invoke(target, args);
    }
}