package com.example.factory.simplefactory.common;

/**
 * 具体产品：ProductC
 */
public class ConcreteProductC implements IProduct {
    @Override
    public void doSomething() {
        System.out.println("I am Product C");
    }
}