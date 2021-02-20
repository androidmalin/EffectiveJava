package com.example.proxy.gpproxy.proxy;

import java.lang.reflect.Method;


public interface PInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
