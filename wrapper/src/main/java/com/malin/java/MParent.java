package com.malin.java;

public abstract class MParent {

    public abstract void function1();

    public abstract void function2();

    public final void run() {
        function1();
        function2();
    }

    static class MChild extends MParent {
        public static void main(String[] args) {
            MParent parent = new MChild();
            parent.run();
        }

        @Override
        public void function1() {
        }

        @Override
        public void function2() {
        }
    }
}

