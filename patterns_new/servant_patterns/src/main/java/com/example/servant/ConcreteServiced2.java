package com.example.servant;

/**
 * 具体服务提供者（ConcreteServiced)：实现所有的服务内容。
 */
public class ConcreteServiced2 implements IServiced {
    @Override
    public void serviced() {
        System.out.println("Serviced 2 doing");
    }
}