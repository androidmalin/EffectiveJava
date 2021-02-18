package com.example.strategy.simple;

public class Client {

    public static void main(String[] args) {

        IStrategy strategyA = new ConcreteStrategyA();
        Context context = new Context(strategyA);
        context.algorithm();

        IStrategy strategyB = new ConcreteStrategyB();
        Context context1 = new Context(strategyB);
        context1.algorithm();
    }
}
