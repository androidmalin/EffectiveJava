package com.example.memento.absfactory.common;

public class ConcreteProductAWithFamilyA implements IAbstractProductA {
    @Override
    public void doA() {
        System.out.println("The ProductA be part of FamilyA");
    }
}