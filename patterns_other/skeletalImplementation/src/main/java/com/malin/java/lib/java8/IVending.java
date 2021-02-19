package com.malin.java.lib.java8;

public interface IVending {

    default void start() {
        System.out.println("Start Vending machine");
    }

    void chooseProduct();

    default void stop() {
        System.out.println("Stop Vending machine");
    }

    default void process() {
        start();
        chooseProduct();
        stop();
    }
}
