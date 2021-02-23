package com.example.iterator.course;

/**
 * 抽象容器
 */
public interface ICourseAggregate<T> {
    void add(T t);

    void remove(T t);

    Iterator<T> iterator();
}
