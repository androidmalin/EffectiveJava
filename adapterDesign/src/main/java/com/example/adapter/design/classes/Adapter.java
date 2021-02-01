package com.example.adapter.design.classes;

/**
 * 由于Adaptee没有提供sampleOperation2()方法，
 * 而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void operation2() {
        System.out.println("Adapter#operation2()");
    }
}
