package com.example.singleton.android;

public abstract class Singleton<T> {

    public Singleton() {
    }

    private T mInstance;

    public abstract T create();

    public final T get() {
        synchronized (this) {
            if (mInstance == null) {
                mInstance = create();
            }
        }
        return mInstance;
    }
}
