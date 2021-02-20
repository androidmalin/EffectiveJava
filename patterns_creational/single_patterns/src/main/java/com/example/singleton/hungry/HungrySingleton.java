package com.example.singleton.hungry;

import java.io.Serializable;

/**
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：某些情况下，可能会造成内存浪费
 * <p>
 * 饿汉式静态代码块单例模式
 * <p>
 * 饿汉式单例的标准写法。
 * 饿汉式单例写法在类加载的时候立即初始化，并且创建单例对象。
 * 它绝对线程安全，在线程还没出现之前就实例化了，不可能存在访问安全问题。
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class HungrySingleton implements Serializable {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
