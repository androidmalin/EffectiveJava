package com.malin.proxy;

/**
 * Class Client1.
 * Interacts with a Car Vehicle directly.
 */
public class Client1 {
    public static void main(String[] args) {
        IVehicle v = new Car("Botar");
        v.start();
        v.forward();
        v.stop();
    }
}
