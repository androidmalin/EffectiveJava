package com.example.builder.general;

/**
 * 当需要创建的产品具备复杂创建过程时，可以抽取出共性创建过程，然后交
 * 由具体实现类自定义创建流程，使得同样的创建行为可以生产出不同的产品，分
 * 离了创建与表示，使创建产品的灵活性大大增加。建造者模式主要适用于以下应
 * 用场景
 * （1）相同的方法，不同的执行顺序，产生不同的结果。
 * （2）多个部件或零件，都可以装配到一个对象中，但是产生的结果又不相
 * 同。
 * （3）产品类非常复杂，或者产品类中不同的调用顺序产生不同的作用。
 * （4）初始化一个对象特别复杂，参数多，而且很多参数都具有默认值。
 */
public class Client {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build().getName());
    }
}
