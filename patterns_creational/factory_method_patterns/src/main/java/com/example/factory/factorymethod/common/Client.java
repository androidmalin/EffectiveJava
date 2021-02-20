package com.example.factory.factorymethod.common;


/**
 * 工厂方法模式的定义
 * 工厂方法模式(Factory Method Pattern)又叫作多态性工厂模式，
 * 指定义一个创建对象的接口，但由实现这个接口的类来决定实例化哪个类，
 * 工厂方法把类的实例化推迟到子类中进行。
 * <p>
 * 在工厂方法模式中，不再由单一的工厂类生产产品，而是由工厂类的子类实现具体产品的创建。
 * <p>
 * 因此，当增加一个产品时，只需增加一个相应的工厂类的子类，实现生产这种产品，
 * 便可以解决简单工厂生产太多产品导致其内部代码臃肿
 * （switch ... case分支过多）的问题，也符合开闭原则。
 * <p>
 * 工厂方法模式的应用场景
 * 工厂方法模式主要适用于以下应用场景。
 * （1）创建对象需要大量重复的代码。
 * （2）客户端（应用层）不依赖产品类实例如何被创建、实现等细节。
 * （3）一个类通过其子类来指定创建哪个对象。
 * <p>
 * <p>
 * 工厂方法模式的优点
 * 1.灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
 * 2.典型的解耦框架。
 * 高层模块只需要知道产品的抽象类，无须关心其他实现类，
 * 满足迪米特法则、依赖倒置原则和里氏替换原则。
 * <p>
 * 工厂方法模式的缺点
 * 1.类的个数容易过多，增加复杂度。
 * 2.增加了系统的抽象性和理解难度。
 * 3.抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
 */
public class Client {
    public static void main(String[] args) {
        IFactory iFactory = new FactoryA();
        IProduct iProduct = iFactory.makeProduct();
        iProduct.doSomething();

        IFactory iFactoryB = new FactoryB();
        IProduct iProductB = iFactoryB.makeProduct();
        iProductB.doSomething();
    }
}
