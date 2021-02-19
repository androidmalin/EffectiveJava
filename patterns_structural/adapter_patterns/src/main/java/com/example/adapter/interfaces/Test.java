package com.example.adapter.interfaces;

public class Test {
    public static void main(String[] args) {
        ISource sourceSub1 = new SourceSub1();
        sourceSub1.function1();

        ISource sourceSub2 = new SourceSub2();
        sourceSub2.function2();
    }
}
