package com.example.iterator.course;

import java.util.List;

/**
 * 具体迭代器
 *
 * @param <E>
 */
public class IteratorImpl<E> implements Iterator<E> {
    private final List<E> list;
    private int cursor;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.print("当前位置 " + cursor + " : ");
        return list.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }
}
