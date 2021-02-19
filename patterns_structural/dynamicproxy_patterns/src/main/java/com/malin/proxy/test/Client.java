package com.malin.proxy.test;

public class Client {
    public static void main(String[] args) {
        test();
        test1();
    }

    private static void test() {
        IBuy proxyBuyer = new StaticProxyBuyer(new Jake());
        proxyBuyer.buy();
    }

    private static void test1() {
        DynamicProxy dynamicProxy = new DynamicProxy(new Tom());
        IBuy instance = dynamicProxy.getInstance();
        instance.buy();
    }
}
