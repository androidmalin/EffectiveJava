package com.example.decorator.pattern.log;

/**
 * 和代理模式一样
 */
public class JsonLogger2 implements ILogger {

    private final ILogger iLogger;

    public JsonLogger2(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    @Override
    public void info(String msg) {
        iLogger.info(msg);
    }

    @Override
    public void error(String msg) {
        iLogger.error(msg);
    }

    @Override
    public void warn(String msg) {
        iLogger.warn(msg);
    }
}
