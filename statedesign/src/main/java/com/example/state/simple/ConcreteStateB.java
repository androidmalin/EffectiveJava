package com.example.state.simple;

/**
 * 具体状态类B
 */
public class ConcreteStateB extends State {
    @Override
    public void handle() {
        System.out.println("StateB do action");
    }
}