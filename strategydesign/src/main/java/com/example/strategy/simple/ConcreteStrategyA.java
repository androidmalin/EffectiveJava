package com.example.strategy.simple;

public class ConcreteStrategyA implements IStrategy{
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyA doSomething");
    }
}
