package com.example.singleton.lazy;


/**
 * 优点：节省了内存,线程安全
 * 缺点：性能低
 * 懒汉式单例模式在外部需要使用的时候才进行实例化
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class LazySimpleSingleton {
    //静态块，公共内存区域
    private static LazySimpleSingleton instance = null;

    private LazySimpleSingleton() {
    }

    public synchronized static LazySimpleSingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
