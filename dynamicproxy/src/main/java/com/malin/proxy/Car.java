package com.malin.proxy;

/**
 * Class Car
 */
public class Car implements IVehicle {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("Car " + name + " started");
    }

    @Override
    public void stop() {

    }

    @Override
    public void forward() {

    }

    @Override
    public void reverse() {

    }

    @Override
    public String getName() {
        return null;
    }
}
