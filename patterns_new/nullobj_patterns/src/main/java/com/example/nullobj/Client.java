package com.example.nullobj;

/**
 * 空对象模式的定义
 * <p>
 * 空对象模式（NullObjectPattern）不属于GoF的设计模式，但是它作为一种
 * 经常出现的模式足以被视为设计模式了。
 * <p>
 * 其具体定义为设计一个空对象取代NULL对象实例的检查。
 * <p>
 * NULL对象不是检查控制，而是反映一个不做任何动作的关系。
 * 这样的NULL对象也可以在数据不可用的时候提供默认的行为，属于行为型设计模式。
 */
public class Client {

    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        System.out.println(factory.getObject("Joe").isNull());
        System.out.println(factory.getObject("Tom").isNull());
    }
}
