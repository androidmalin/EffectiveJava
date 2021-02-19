package com.example.factory.simplefactory.common;

/**
 * 具体产品：ProductA
 */
public class ConcreteProductA implements IProduct {
    @Override
    public void doSomething() {
        System.out.println("I am Product A");
    }
}