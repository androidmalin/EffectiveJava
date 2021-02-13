package com.example.memento.absfactory.common;

public class ConcreteProductAWithFamilyB implements IAbstractProductA{
    @Override
    public void doA() {
        System.out.println("The ProductA be part of FamilyB");
    }
}
