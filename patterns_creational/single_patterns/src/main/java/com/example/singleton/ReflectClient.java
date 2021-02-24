package com.example.singleton;

import com.example.singleton.lazy.LazyDoubleCheckSingleton;
import com.example.singleton.lazy.LazySimpleSingleton;
import com.example.singleton.lazy.LazyStaticInnerClassSingleton;
import com.example.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

/**
 * https://juejin.cn/post/6844903960009162759
 */
public class ReflectClient {

    public static void main(String[] args) {
        reflectSingleton(LazySimpleSingleton.class);
        reflectSingleton(LazyDoubleCheckSingleton.class);
        //reflectSingleton(LazyStaticInnerClassSingleton.class);
        //reflectSingleton(EnumSingleton.class);
        //reflectEnum();
        //threadTest();
    }

    private static void reflectSingleton(Class<?> clazz) {
        try {
            // 通过反射拿到私有的构造方法
            Constructor<?> constructor = clazz.getDeclaredConstructor();

            // 设置访问属性，强制访问
            constructor.setAccessible(true);

            // 暴力初始化两次，这就相当于调用了两次构造方法
            Object o1 = constructor.newInstance();
            Object o2 = constructor.newInstance();

            // 只要 o1和o2 地址不相等，就可以说明这是两个不同的对象，也就是违背了单例模式的初衷
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    private static void reflectEnum() {
        try {
            Class<?> clazz = EnumSingleton.class;
            Constructor<?> c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton enumSingleton = (EnumSingleton) c.newInstance("Eamon", 666);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void threadTest() {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
    }

    private static class ExecutorThread implements Runnable {
        @Override
        public void run() {
            LazyStaticInnerClassSingleton singleton = LazyStaticInnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + singleton);
        }
    }
}
