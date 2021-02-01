package com.malin.java;

public class G {
    public static void main(String[] args) {
        ILife life = new ILifeImpl();
        life.function2();
    }
    public static class ILifeImpl implements ILife {
        ILife delegate = new AbsILife() {
            @Override
            public void function2() {
            }
        };
        abstract static class AbsILife implements ILife {
            @Override
            public void function1() {
            }
        }
        @Override
        public void function1() {
            delegate.function1();
        }
        @Override
        public void function2() {
            delegate.function1();
        }
    }

    public interface ILife {
        void function1();
        void function2();
    }
}
