package com.example.factory.absfactory.common;

public class ConcreteProductBWithFamilyB implements IAbstractProductB {
    @Override
    public void doB() {
        System.out.println("The ProductB be part of FamilyB");
    }
}
