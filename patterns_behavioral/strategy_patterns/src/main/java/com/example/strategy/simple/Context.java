package com.example.strategy.simple;

public class Context implements IStrategy {

    private final IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    @Override
    public void algorithm() {
        iStrategy.algorithm();
    }
}
