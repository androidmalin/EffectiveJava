package com.malin.java.lib.java7;


/**
 * Step 2:创建一个抽象类实现这个接口，并且在抽象类中实现一些接口中的通用方法.
 */
public abstract class AbstractVending implements IVending {

    @Override
    public void start() {
        System.out.println("Start Vending machine");
    }

    @Override
    public void stop() {
        System.out.println("Stop Vending machine");
    }

    @Override
    public void process() {
        start();
        chooseProduct();
        stop();
    }
}