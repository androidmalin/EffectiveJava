package com.example.singleton.android;

public class Client {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        LogSingleton logSingleton = new LogSingleton();
        Log log = logSingleton.get();
        log.info("test1");
    }

    private static void test2() {
        Singleton<Log> singleton = new Singleton<Log>() {
            @Override
            public Log create() {
                return new Log();
            }
        };
        Log log = singleton.get();
        log.info("test2");
    }
}
