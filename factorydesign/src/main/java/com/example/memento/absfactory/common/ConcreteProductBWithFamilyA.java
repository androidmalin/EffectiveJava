package com.example.memento.absfactory.common;

public class ConcreteProductBWithFamilyA implements IAbstractProductB {
    @Override
    public void doB() {
        System.out.println("The ProductB be part of FamilyA");
    }
}
