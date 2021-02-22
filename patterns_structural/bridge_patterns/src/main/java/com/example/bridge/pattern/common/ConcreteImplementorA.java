package com.example.bridge.pattern.common;

/**
 * 具体实现A
 */
public class ConcreteImplementorA implements IImplementor {

    @Override
    public void operationImpl() {
        System.out.println("I'm ConcreteImplementor A");
    }
}