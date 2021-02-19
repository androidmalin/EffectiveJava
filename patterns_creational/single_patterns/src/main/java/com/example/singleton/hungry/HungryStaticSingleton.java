package com.example.singleton.hungry;

/**
 * 饿汉式静态代码块单例模式
 * <p>
 * 这种写法使用静态块的机制，非常简单也容易理解。
 * <p>
 * 饿汉式单例写法适用于单例对象较少的情况。
 * <p>
 * 这样写可以保证绝对线程安全，执行效率比较高。
 * 但是它的缺点也很明显，就是所有对象类在加载的时候就实例化。
 * <p>
 * 这样一来，如果系统中有大批量的单例对象存在，而且单例对象的数量也不确定，则系统初始化时会
 * 造成大量的内存浪费，从而导致系统内存不可控。
 * <p>
 * 也就是说，不管对象用或不用，都占着空间，浪费了内存，有可能占着内存又不使用。
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class HungryStaticSingleton {
    private static final HungryStaticSingleton instance;

    static {
        instance = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance() {
        return instance;
    }
}
