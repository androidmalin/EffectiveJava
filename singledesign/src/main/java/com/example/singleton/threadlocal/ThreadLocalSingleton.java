package com.example.singleton.threadlocal;

/**
 * 线程单例实iÆThreadLocal。ThreadLocal不能保证
 * 其创建的对象是全局唯一的，但能保证在单个线程中是唯一的，是线程安全的。
 * 下面来看代码。
 * <p>
 * 在主线程中无论调用多少次，获取的实例都是同一个，都在两个子线程中分别获取了不同的实例。
 * <p>
 * 那么，ThreadLocal是如何实现这样的效果的呢？
 * 我们知道，单例模式为了达到线程安全的目的，会给方法上锁，以时间换空间。
 * <p>
 * ThreadLocal将所有对象全部放在ThreadLocalMap中，为每个线程都提供一个对象，
 * 实际上是以空间换时间来实现线程隔离的。
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
