package com.example.observer.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题者
 *
 * @param <E>
 */
public class ConcreteSubject<E> implements ISubject<E> {
    private final List<IObserver<E>> observers = new ArrayList<>();

    @Override
    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        for (IObserver<E> observer : this.observers) {
            observer.update(event);
        }
    }
}