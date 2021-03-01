package com.malin.proxy.shape;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Client7ProxyFactory implements InvocationHandler {

    private final IShape target;

    public Client7ProxyFactory(IShape target) {
        this.target = target;
    }

    public IShape getProxy() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        return (IShape) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    public IShape getProxy2() {
        return new $Proxy0(this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("proxy:" + proxy.getClass().getName());
        System.err.println("method:" + method.toGenericString());
        System.err.println("args:" + Arrays.toString(args));
        System.err.println("target:" + target.getClass().getName());
        return method.invoke(target, args);
    }
}
