package com.example.observer.common;

/**
 * 具体观察者
 *
 * @param <E>
 */
public class ConcreteObserver<E> implements IObserver<E> {

    @Override
    public void update(E event) {
        System.out.println("receive event: " + event);
    }
}