package com.example.observer.common;

/**
 * 抽象观察者
 *
 * @param <E>
 */
public interface IObserver<E> {
    void update(E event);
}