package com.example.practice.common;

public class Java_I {

    /**
     * Gradle build finished in
     * 9 m 51 s 204 ms
     */
    public static void main(String[] args) {
        long times = 1_000_000_000_000L;

        System.out.println("========== ++i ==========");
        long t1_start = System.nanoTime();
        for (long i = 0; i < times; ++i) ;
        long t1_end = System.nanoTime();
        System.out.println(t1_end - t1_start);

        System.out.println("========== i++ ==========");
        long t2_start = System.nanoTime();
        for (long i = 0; i < times; i++) ;
        long t2_end = System.nanoTime();
        System.out.println(t2_end - t2_start);
    }

}
