package com.example.adapter.objectes;


/**
 * 对象适配器模式
 * 与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，
 * 与类的适配器模式不同的是，
 * 对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 * <p>
 * <p>
 * Adaptee类并没有sampleOperation2()方法，
 * 而客户端则期待这个方法。
 * 为使客户端能够使用Adaptee类，需要提供一个包装(Wrapper)类Adapter。
 * 这个包装类包装了一个Adaptee的实例，从而此包装类能够把Adaptee的API与Target类的API衔接起来。
 * Adapter与Adaptee是委派关系，这决定了适配器模式是对象的。
 */
public class Test {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.sampleOperation1();
        target.sampleOperation2();
    }
}
