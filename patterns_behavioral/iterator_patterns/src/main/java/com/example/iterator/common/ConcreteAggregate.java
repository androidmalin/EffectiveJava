package com.example.iterator.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体容器(ConcreteAggregate): 创建具体迭代器。
 *
 * @param <E>
 */
public class ConcreteAggregate<E> implements IAggregate<E> {
    private final List<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return this.list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return this.list.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.list);
    }

}