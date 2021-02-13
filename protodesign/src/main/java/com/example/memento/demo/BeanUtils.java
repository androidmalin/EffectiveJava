package com.example.memento.demo;

import java.lang.reflect.Field;
import java.util.Objects;

public class BeanUtils {
    public static Object copy(Object protoType) {
        Objects.requireNonNull(protoType);
        Class<?> clazz = protoType.getClass();
        Object returnValue = null;
        try {
            returnValue = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(returnValue, field.get(protoType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
