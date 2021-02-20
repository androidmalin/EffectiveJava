package com.example.proxy.common;

/**
 * 真实主题角色
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}