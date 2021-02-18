package com.example.strategy.factorymethod;

//生产ProductA的具体工厂类
public class FactoryA implements IFactory {
    @Override
    public IProduct makeProduct() {
        return new ProductA();
    }
}
