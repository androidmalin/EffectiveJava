package generics.fibonacci;

import java.util.Iterator;

public class IterableFabonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFabonacci(int count) {
        this.n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFabonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        IterableFabonacci integers = new IterableFabonacci(18);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
