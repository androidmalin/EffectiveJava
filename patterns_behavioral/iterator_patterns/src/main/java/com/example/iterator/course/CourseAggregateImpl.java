package com.example.iterator.course;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体迭代器
 */
public class CourseAggregateImpl<T> implements ICourseAggregate<T> {
    private final List<T> list;

    public CourseAggregateImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<>(list);
    }
}
