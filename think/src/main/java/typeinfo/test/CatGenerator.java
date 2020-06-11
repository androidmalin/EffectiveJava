package typeinfo.test;

import generics.Generator;

public class CatGenerator<T> implements Generator<T> {
    private T t;

    public CatGenerator(T t) {
        this.t = t;
    }

    @Override
    public T next() {
        return t;
    }
}
