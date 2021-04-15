package com.example.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 虽然枚举式单例写法更加优雅，但是也会存在一些问题。
 * 因为它在类加载时将所有的对象初始化都放在类内存中，这其实和饿汉式单例写法并无差异，不适
 * 合大量创建单例对象的场景。
 * <p>
 * 接下来看注册式单例模式的另一种写法，即容器式
 * 伊写法，创建ContainerSingleton类。
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<Class<?>, Object> iocMap = new ConcurrentHashMap<>();

    public static Object getInstance2(Class<?> clazz) {
        Object instance = null;
        if (!iocMap.containsKey(clazz)) {
            try {
                instance = clazz.newInstance();
                iocMap.put(clazz, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        } else {
            return iocMap.get(clazz);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<?> clazz) {
        Object object = null;
        if (!iocMap.containsKey(clazz)) {
            try {
                object = clazz.newInstance();
                iocMap.put(clazz, object);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            object = iocMap.get(clazz);
        }
        return (T) object;
    }
}
