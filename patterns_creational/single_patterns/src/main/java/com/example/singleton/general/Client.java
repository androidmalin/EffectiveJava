package com.example.singleton.general;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

    //饿汉式,在类加载的时候.立即初始化.它绝对线程安全.
    @SuppressWarnings("InstantiationOfUtilityClass")
    private static class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return instance;
        }
    }
}
