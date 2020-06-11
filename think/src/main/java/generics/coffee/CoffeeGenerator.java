package generics.coffee;

import java.util.Iterator;
import java.util.Random;

import generics.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class<?>[] types = {
            Latte.class,
            Mocha.class,
            Cappuccino.class,
            Americano.class,
            Breve.class,
    };

    // For iteration:
    private int size = 0;
    private static Random mRandom = new Random(47);

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[mRandom.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        private int count;

        public CoffeeIterator(int count) {
            this.count = count;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator(size);
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }
}
