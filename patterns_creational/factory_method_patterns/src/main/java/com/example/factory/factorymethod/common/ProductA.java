package com.example.factory.factorymethod.common;

/**
 * 具体产品：ProductA
 */
public class ProductA implements IProduct {
    @Override
    public void doSomething() {
        System.out.println("ProductA doSomething");
    }
}
