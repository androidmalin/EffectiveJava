package com.malin.proxy;

public class Main {
    public static void main(String[] args) {
        IVehicle v = new Car("Botar");
        v.start();
        v.forward();
        v.stop();
    }
}
