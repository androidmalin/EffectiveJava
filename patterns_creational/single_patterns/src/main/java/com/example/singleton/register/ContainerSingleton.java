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

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        Object instance = null;
        if (!ioc.containsKey(className)) {
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        } else {
            return ioc.get(className);
        }
    }

}
