package com.example.strategy.common;

/**
 * 具体策略类
 * 具体策略角色（ConcreteStrategy)。具体的策略或算法实现。
 */
public class ConcreteStrategyA implements IStrategy {
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyA doSomething");
    }
}
