package com.example.strategy.absfactory.common;

public class Test {
    public static void main(String[] args) {
        IAbstractFactory iAbstractFactoryA = new ConcreteFactoryA();
        iAbstractFactoryA.makeProductA().doA();
        iAbstractFactoryA.makeProductB().doB();

        IAbstractFactory iAbstractFactoryB = new ConcreteFactoryB();
        iAbstractFactoryB.makeProductA().doA();
        iAbstractFactoryB.makeProductB().doB();
    }
}
