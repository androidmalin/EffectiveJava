package com.example.decorator.pattern.log;

public abstract class AbsLogDecorator implements ILogger {

    protected final ILogger iLogger;

    public AbsLogDecorator(ILogger iLogger) {
        this.iLogger = iLogger;
    }
}
