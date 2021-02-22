package com.example.adapter.interfaces.use;

/**
 * 接口适配器
 * <p>
 * 接口适配器的关注点与类适配器、对象适配器的关注点不太一样，
 * 类适配器和对象适配器着重于将系统存在的一个角色（Adaptee）转化成目标接口
 * （Target）所需的内容
 * <p>
 * 而接口适配器的使用场景是当接口的方法过多时，如果直接实现接口，
 * 则类会多出许多空实现的方法，显得很臃肿。
 * <p>
 * 此时，使用接口适配器就能只实现我们需要的接口方法，使目标更清晰。其UML类图如下。
 */
public class Client {
    public static void main(String[] args) {
        ISource sourceSub1 = new SourceSub1();
        sourceSub1.function1();

        ISource sourceSub2 = new SourceSub2();
        sourceSub2.function2();
    }
}
