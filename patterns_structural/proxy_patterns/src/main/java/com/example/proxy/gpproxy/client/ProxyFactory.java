package com.example.proxy.gpproxy.client;


import com.example.proxy.gpproxy.proxy.PClassLoader;
import com.example.proxy.gpproxy.proxy.PInvocationHandler;
import com.example.proxy.gpproxy.proxy.PProxy;

import java.lang.reflect.Method;


public class ProxyFactory implements PInvocationHandler {
    private ITeacher target;

    public ITeacher getInstance(ITeacher target) {
        this.target = target;
        return (ITeacher) PProxy.newProxyInstance(
                new PClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("===before===");
    }

    private void after() {
        System.out.println("===after===");
    }
}
