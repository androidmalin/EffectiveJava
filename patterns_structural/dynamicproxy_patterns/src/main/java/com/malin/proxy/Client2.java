package com.malin.proxy;


/**
 * 现在，让客户端通过代理与目标对象进行交互
 * 请记住，代理的主要目的是控制对目标对象的访问，而不是增强目标对象的功能。
 */
public class Client2 {
    public static void main(String[] args) {
        IVehicle originCar = new Car("Botar");
        IVehicle proxyCar = new VehicleProxy(originCar);
        proxyCar.start();
        proxyCar.forward();
        proxyCar.stop();
    }
}