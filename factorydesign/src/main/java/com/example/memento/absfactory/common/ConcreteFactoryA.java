package com.example.memento.absfactory.common;

public class ConcreteFactoryA implements IAbstractFactory {
    @Override
    public IAbstractProductA makeProductA() {
        return new ConcreteProductAWithFamilyA();
    }

    @Override
    public IAbstractProductB makeProductB() {
        return new ConcreteProductBWithFamilyA();
    }
}
