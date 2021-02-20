package com.example.proto.common;

/**
 * 抽象原型
 *
 * @param <T>
 */
public interface IPrototype<T> {
    T clone();
}