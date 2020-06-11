package generics.fabonacci;

import generics.Generator;

public class Fabonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fabonacci fabonacci = new Fabonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(fabonacci.next());
        }
    }
}
