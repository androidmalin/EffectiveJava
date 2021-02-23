package com.example.iterator.common;

/**
 * 抽象容器(IAggregate): 负责定义提供具体迭代器的接口。
 *
 * @param <E>
 */
public interface IAggregate<E> {

    boolean add(E element);

    boolean remove(E element);

    Iterator<E> iterator();
}