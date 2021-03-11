package com.mvp.example.last;

public class Foo {
    public interface Bar {
        void callback();
    }

    public static void registerCallback(Bar bar) {
    }

    public static void main(String[] args) {
        Foo.registerCallback(new Foo.Bar() {
            @Override
            public void callback() {
            }
        });
    }
}

