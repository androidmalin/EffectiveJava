package com.example.factory.absfactory.common;


/**
 * 抽象工厂模式的优点
 * （1）当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品族
 * （2）抽象工厂增强了程序的可扩展性，对于新产品族的增加，只需实现一个
 * 新的具体工厂即可，不需要对已有代码进行修改，符合开闭原则。
 * <p>
 * 抽象工厂模式的缺点
 * （1）规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要
 * 修改抽象工厂的接口。
 * （2）增加了系统的抽象性和理解难度。
 */
public class Client {
    public static void main(String[] args) {
        IAbstractFactory factory = new ConcreteFactoryA();

        IAbstractProductA productA = factory.makeProductA();
        productA.doA();

        IAbstractProductB productB = factory.makeProductB();
        productB.doB();

        IAbstractFactory iAbstractFactoryB = new ConcreteFactoryB();
        iAbstractFactoryB.makeProductA().doA();
        iAbstractFactoryB.makeProductB().doB();
    }
}
