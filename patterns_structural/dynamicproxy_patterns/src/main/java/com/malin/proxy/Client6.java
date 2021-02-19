package com.malin.proxy;

import java.lang.reflect.Proxy;

/**
 * Class Client6.
 * Interacts with a Rectangle Shape through a dynamically * generated proxy and a Generic Logger.
 */
public class Client6 {
    public static void main(String[] args) {
        IShape rect = new Rectangle();
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        IShape s = (IShape) Proxy.newProxyInstance(
                IShape.class.getClassLoader(),
                new Class[]{IShape.class},
                new GenericLogger(rect)
        );
        s.draw();
        s.move();
        s.resize();
    }
}