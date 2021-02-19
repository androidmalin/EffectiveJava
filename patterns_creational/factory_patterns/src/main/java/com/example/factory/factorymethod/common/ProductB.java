package com.example.factory.factorymethod.common;

/**
 * 具体产品：ProductB
 */
public class ProductB implements IProduct {
    @Override
    public void doSomething() {
        System.out.println("ProductB doSomething");
    }
}
