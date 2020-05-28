package com.malin.proxy;

import java.lang.reflect.Proxy;

/**
 * Class Client5.
 * Interacts with a Car Vehicle through a dynamically * generated proxy and a Generic Logger.
 */
public class Client5 {
    public static void main(String[] args) {
        IVehicle c = new Car("Botar");
        IVehicle v = (IVehicle) Proxy.newProxyInstance(
                IVehicle.class.getClassLoader(),
                new Class[]{IVehicle.class},
                new GenericLogger(c));
        v.start();
        v.forward();
        v.stop();
    }
}