package com.example.factory.simplefactory.common;

/**
 * 具体产品：ProductB
 */
public class ConcreteProductB implements IProduct {
    @Override
    public void doSomething() {
        System.out.println("I am Product B");
    }
}
