package com.example.interfaceabs.demo.mock;

public class MockInterface {
    protected MockInterface() {
    }

    public void funcA() {
        throw new NullPointerException("xx");
    }
}

