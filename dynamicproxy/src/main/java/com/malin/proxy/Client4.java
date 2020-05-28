package com.malin.proxy;

public class Client4 {
    public static void main(String[] args) {
        IVehicle c = new Car("Botar");
        IVehicle v = new LoggedVehicle(c);
        v.start();
        v.forward();
        v.stop();
    }
}