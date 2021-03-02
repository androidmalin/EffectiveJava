package com.malin.proxy.shape;

public class Client7 {

    public static void main(String[] args) {
        testProxy();
    }

    private static void testProxy() {
        IShape iShape = new Rectangle();
        IShape iShapePoxy = new Client7ProxyFactory(iShape).getProxy2();
        iShapePoxy.draw();
    }

    private static void testDynamicProxy() {
        IShape iShape = new Rectangle();
        IShape iShapePoxy = new Client7ProxyFactory(iShape).getProxy();
        iShapePoxy.draw();
    }
}
