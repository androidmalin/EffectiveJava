package com.example.interfaceabs;

public class ClassC extends AbstractB {

    @Override
    public void function_AbstractA() {
        System.out.println("function_AbstractA");
    }

    @Override
    public void function_InterfaceB1() {
        System.out.println("function_InterfaceB1");
    }

    @Override
    public void function_InterfaceB2() {
        System.out.println("function_InterfaceB2");
    }

    @Override
    public void function_InterfaceC1() {
        System.out.println("function_InterfaceC1");
    }

    @Override
    public void function_InterfaceC2() {
        System.out.println("function_InterfaceC2");
    }
}
