package com.example.iterator.common;

/**
 * 抽象迭代器（Iterator）: 负责定义访问和遍历元素的接口
 *
 * @param <E>
 */
public interface Iterator<E> {

    E next();

    boolean hasNext();
}