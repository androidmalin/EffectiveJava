package net.mindview.util;

import typeinfo.pets.Cat;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }


    public static void main(String[] args) {
        Generator<Cat> catGenerator = BasicGenerator.create(Cat.class);
        Cat cat = catGenerator.next();
        System.out.println(cat);
    }
}
