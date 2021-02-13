package com.example.memento.absfactory.common;

public class ConcreteFactoryB implements IAbstractFactory {
    @Override
    public IAbstractProductA makeProductA() {
        return new ConcreteProductAWithFamilyB();
    }

    @Override
    public IAbstractProductB makeProductB() {
        return new ConcreteProductBWithFamilyB();
    }
}
