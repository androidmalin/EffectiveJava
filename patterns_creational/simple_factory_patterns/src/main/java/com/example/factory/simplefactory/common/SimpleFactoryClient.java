package com.example.factory.simplefactory.common;

/**
 * 简单工厂模式的定义
 * <p>
 * 简单工厂模式（Simple Factory Pattern）又叫作静态工厂方法模式（Static Factory Method Pattern），
 * 简单来说，简单工厂模式有一个具体的工厂类，可以生成多个不同的产品，
 * 属于创建型设计模式。
 * <p>
 * 简单工厂模式不在GoF23种设计模式之列。
 * <p>
 * 简单工厂模式的应用场景
 * 对于产品种类相对较少的情况，考虑使用简单工厂模式可以很方便地创建所需产品。
 * 使用简单工厂模式的客户端只需要传入工厂类的参数，
 * 不需要关心如何创建对象的逻辑。
 * <p>
 * <p>
 * 客户端调用虽然简单了，但如果业务继续扩展，要增加新的产品的话,
 * 则工厂中的makeProduct()方法就要随着产品链的丰富每次都要修改代码逻辑，
 * 不符合开闭原则。
 * <p>
 * <p>
 * 且简单工厂模式的优点
 * 简单工厂模式的结构简单，调用方便。对于外界给定的信息，可以很方便地
 * 创建出相应的产品。工厂和产品的职责区分明确。
 * <p>
 * 简单工厂模式的缺点
 * 简单工厂模式的工厂类单一，负责所有产品的创建，但当产品基数增多时，
 * 工厂类代码会非常臃肿，违背高聚合原则。
 */
public class SimpleFactoryClient {
    public static void main(String[] args) {
        IProduct iProduct = SimpleFactory.makeProduct(Const.PRODUCT_A);
        iProduct.doSomething();
    }
}
