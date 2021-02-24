package com.example.servant;

/**
 * 具体功能
 * 具体服务提供者（ConcreteServiced)：实现所有的服务内容。
 */
public class ConcreteServiced1 implements IServiced {
    @Override
    public void serviced() {
        System.out.println("Serviced 1 doing");
    }
}