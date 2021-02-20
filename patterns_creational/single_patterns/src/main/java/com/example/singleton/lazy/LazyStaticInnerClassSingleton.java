package com.example.singleton.lazy;

import java.io.Serializable;

/**
 * ClassPath : LazyStaticInnerClassSingleton.class
 * LazyStaticInnerClassSingleton$LazyHolder.class
 * 优点：写法优雅，利用了Java本身语法特点，性能高，避免了内存浪费,不能被反射破坏
 * 缺点：不优雅
 * <p>
 * 这种形式兼顾饿汉式单例模式的内存浪费问题和synchronized的性能问题
 * 完美地屏蔽了这两个缺点
 * 自认为史上最牛的单例模式的实现方式
 */
public class LazyStaticInnerClassSingleton implements Serializable {

    @SuppressWarnings("ALL")
    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 每一个关键字都不是多余的，static是为了使单例的空间共享，保证这个方法不会被重写、重载
     */
    public static LazyStaticInnerClassSingleton getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.INSTANCE;
    }

    /**
     * 外部类初次加载，会初始化静态变量、静态代码块、静态方法，但不会加载内部类和静态内部类。
     * 利用了Java本身语法特点，内部类默认不加载
     */
    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

    /**
     * 解决反序列化对象不一致问题
     */
    private Object readResolve() {
        return LazyHolder.INSTANCE;
    }
}
