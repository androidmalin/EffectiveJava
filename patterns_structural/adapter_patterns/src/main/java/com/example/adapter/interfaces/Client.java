package com.example.adapter.interfaces;

/**
 * 接口适配器
 * <p>
 * 接口适配器的主要原理: 使用抽象类实现接口，并且空实现众多。
 * <p>
 * 接口适配器的关注点与类适配器、对象适配器的关注点不太一样，
 * 类适配器和对象适配器着重于将系统存在的一个角色（Adaptee）转化成目标接口
 * （Target）所需的内容
 * <p>
 * 而接口适配器的使用场景是当接口的方法过多时，如果直接实现接口，
 * 则类会多出许多空实现的方法，显得很臃肿。
 * <p>
 * 此时，使用接口适配器就能只实现我们需要的接口方法，使目标更清晰。
 * <p>
 * <p>
 * <p>
 * 适配器模式的优点
 * （1）能提高类的透明性和复用，但现有的类复用不需要改变。
 * （2）适配器类和原角色类解耦，提高程序的扩展性。
 * （3）在很多业务场景中符合开闭原则。
 * <p>
 * <p>
 * 适配器模式的缺点
 * （1）适配器编写过程需要结合业务场景全面考虑，可能会增加系统的复杂
 * （2）增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。
 */
public class Client {
    public static void main(String[] args) {
        ITarget adapter = new Adapter(new Adaptee()) {
            @Override
            public int request1() {
                return adaptee.specificRequest() / 44;
            }
        };
        int result = adapter.request1();
        System.out.println(result);
    }
}
