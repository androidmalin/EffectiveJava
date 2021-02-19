package com.example.strategy.simple;

public class ConcreteStrategyB implements IStrategy{
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyB doSomething");
    }
}
