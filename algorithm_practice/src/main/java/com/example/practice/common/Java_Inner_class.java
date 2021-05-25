package com.example.practice.common;

import org.junit.jupiter.api.Test;

public class Java_Inner_class {
    @Test
    public void main() {
        test(new Object() {
            public void child() {
                System.out.println("child");
            }

            public void child2() {
                System.out.println("child2");
            }
        });
    }

    public void test(Object object) {

    }
}
