package com.example.strategy.common;

/**
 * 具体策略类
 */
public class ConcreteStrategyB implements IStrategy {
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyB doSomething");
    }
}
