package com.example.decorator.pattern.log;

public class Logger implements ILogger {
    @Override
    public void info(String msg) {
        System.out.println("info: " + msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("error: " + msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("warn: " + msg);
    }
}
