package com.example.objectpool.example;

import java.util.Enumeration;
import java.util.Hashtable;

// Java program to illustrate
// Object Pool Design Pattern
public abstract class ObjectPool<T> {
    private final long deadTime;

    private final Hashtable<T, Long> lock;
    private final Hashtable<T, Long> unlock;

    public ObjectPool() {
        deadTime = 50000; // 50 seconds
        lock = new Hashtable<>();
        unlock = new Hashtable<>();
    }

    public abstract T create();

    public abstract boolean validate(T o);

    public abstract void dead(T o);

    /**
     * 取出
     */
    public synchronized T takeOut() {
        long now = System.currentTimeMillis();
        T t;
        if (unlock.size() > 0) {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlock.get(t)) > deadTime) {
                    // object has deadd
                    unlock.remove(t);
                    dead(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        unlock.remove(t);
                        lock.put(t, now);
                        return t;
                    } else {
                        // object failed validation
                        unlock.remove(t);
                        dead(t);
                        t = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        t = create();
        lock.put(t, now);
        return t;
    }

    public synchronized void takeIn(T t) {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }
}

// Three methods are abstract
// and therefore must be implemented by the subclass

