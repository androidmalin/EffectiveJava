package com.example.bridge.pattern.common;

/**
 * 具体实现B
 */
public class ConcreteImplementorB implements IImplementor {

    @Override
    public void operationImpl() {
        System.out.println("I'm ConcreteImplementor B");
    }
}