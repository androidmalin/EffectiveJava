package com.example.nullobj;

/**
 * 真实对象
 */
public class RealObject extends AbstractObject {
    private String name;

    public RealObject(String name) {
        this.name = name;
    }

    @Override
    public void request() {
        System.out.println("Do something...");
    }

    @Override
    boolean isNull() {
        return false;
    }
}