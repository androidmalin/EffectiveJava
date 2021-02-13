package com.example.memento.simplefactory.origin;

public class SimpleFactoryClient {
    public static void main(String[] args) {
        SimpleFactory.makeProduct(Const.PRODUCT_A).doSomething();
    }

    /**
     * 抽象产品
     */
    public interface IProduct {
        void doSomething();
    }

    /**
     * 具体产品：ProductA
     */
    private static class ConcreteProductA implements IProduct {
        @Override
        public void doSomething() {
            System.out.println("I am Product A");
        }
    }

    /**
     * 具体产品：ProductB
     */
    private static class ConcreteProductB implements IProduct {
        @Override
        public void doSomething() {
            System.out.println("I am Product B");
        }
    }

    /**
     * 具体产品：ProductC
     */
    private static class ConcreteProductC implements IProduct {
        @Override
        public void doSomething() {
            System.out.println("I am Product C");
        }
    }

    private static final class Const {
        private static final int PRODUCT_A = 0;
        private static final int PRODUCT_B = 1;
        private static final int PRODUCT_C = 2;
    }

    private static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            IProduct iProduct;
            switch (kind) {
                default:
                case Const.PRODUCT_A: {
                    iProduct = new ConcreteProductA();
                }
                case Const.PRODUCT_B: {
                    iProduct = new ConcreteProductB();
                }
                case Const.PRODUCT_C: {
                    iProduct = new ConcreteProductC();
                }
            }
            return iProduct;
        }
    }
}
