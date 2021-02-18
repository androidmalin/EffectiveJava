package com.example.strategy.factorymethod;

//生产ProductB的具体工厂类
public class FactoryB implements IFactory {
    @Override
    public IProduct makeProduct() {
        return new ProductB();
    }
}
