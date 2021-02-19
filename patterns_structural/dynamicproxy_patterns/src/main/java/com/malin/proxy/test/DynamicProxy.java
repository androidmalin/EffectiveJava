package com.malin.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private final IBuy iBuy;

    public DynamicProxy(IBuy iBuy) {
        this.iBuy = iBuy;
    }

    public IBuy getInstance() {
        return (IBuy) Proxy.newProxyInstance(
                iBuy.getClass().getClassLoader(),
                iBuy.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(iBuy, args);
    }
}
