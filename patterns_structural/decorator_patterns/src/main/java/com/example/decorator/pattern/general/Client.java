package com.example.decorator.pattern.general;

/**
 * 装饰者模式,直接看书 设计模式就该这么学
 * <p>
 * 别看尚学堂的视频,那个没有解释清楚.浪费时间.
 */
public class Client {
    public static void main(String[] args) {

        //首先创建需要被装饰的原始对象(即要被装饰的对象)
        AbsComponent c1 = new ConcreteComponent();

        //给对象透明的增加功能A并调用
        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();

        //给对象透明的增加功能B并调用
        Decorator decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();

        //装饰器也可以装饰具体的装饰对象，此时相当于给对象在增加A的功能基础上在添加功能B
        Decorator decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();
    }
}