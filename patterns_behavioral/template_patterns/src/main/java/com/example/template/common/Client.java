package com.example.template.common;

/**
 * 模板方法模式适用于以下应用场景。
 * （1）一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
 * （2）各子类中公共的行为被提取出来，集中到一个公共的父类中，从而避免代码重复。
 * <p>
 * <p>
 * 模板方法模式的优点
 * （1）利用模板方法将相同处理逻辑的代码放到抽象父类中，可以提高代码的
 * 复用性。
 * （2）将不同的算法逻辑分离到不同的子类中，通过对子类的扩展增加新的行为，提高代码的可扩展性。
 * （3）把不变的行为写在父类上，去除子类的重复代码，提供了一个很好的代码复用平台，符合开闭原则。
 * <p>
 * 模板方法模式的缺点
 * （1）每一个抽象类都需要一个子类来实现，这样导致类数量增加。
 * （2）类数量的增加，间接地增加了系统实现的复杂度。
 * （3）由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        System.out.println("=======");

        abc = new ConcreteClassB();
        abc.templateMethod();
    }
}
