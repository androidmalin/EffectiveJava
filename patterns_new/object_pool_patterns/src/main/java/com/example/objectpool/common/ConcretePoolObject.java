package com.example.objectpool.common;

/**
 * 具体对象
 */
public class ConcretePoolObject implements IPooledObject {

    @Override
    public void operation() {
        System.out.println("doing");
    }
}