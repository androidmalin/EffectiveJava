package com.example.flyweight.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class FlyweightFactory {

    private static final Map<String, IFlyweight> POOL = new HashMap<>();

    /**
     * 因为内部状态具备不变性，因此作为缓存的键
     */
    public static IFlyweight getFlyweight(String intrinsicState) {
        if (!POOL.containsKey(intrinsicState)) {
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            POOL.put(intrinsicState, flyweight);
        }
        return POOL.get(intrinsicState);
    }
}