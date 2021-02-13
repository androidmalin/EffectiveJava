package com.example.memento.factorymethod;

//具体产品：ProductA
public class ProductA implements IProduct{
    @Override
    public void doSomething() {
        System.out.println("ProductA doSomething");
    }
}
