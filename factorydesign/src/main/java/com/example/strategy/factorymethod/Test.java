package com.example.strategy.factorymethod;

public class Test {
    public static void main(String[] args) {
        IFactory iFactory = new FactoryA();
        IProduct iProduct = iFactory.makeProduct();
        iProduct.doSomething();
    }
}