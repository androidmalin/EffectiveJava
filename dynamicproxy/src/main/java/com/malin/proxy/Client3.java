package com.malin.proxy;

import java.lang.reflect.Proxy;

public class Client3 {
    public static void main(String[] args) {
        IVehicle car = new Car("hd");
        IVehicle proxyCar = (IVehicle) Proxy.newProxyInstance(
                IVehicle.class.getClassLoader(),
                new Class[]{IVehicle.class},
                new VehicleHandler(car)
        );
        proxyCar.start();
        proxyCar.forward();
        proxyCar.stop();
    }
}