package com.example.iterator.common;

import java.util.List;

/**
 * 具体迭代器(ConcreteIterator)：提供具体的元素遍历行为。
 *
 * @param <E>
 */
public class ConcreteIterator<E> implements Iterator<E> {
    private final List<E> list;
    private int cursor = 0;

    public ConcreteIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        return this.list.get(this.cursor++);
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.list.size();
    }
}