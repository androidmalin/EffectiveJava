package com.example.decorator.pattern.log;


public class XMLLoggerDecorator extends AbsLogDecorator implements ILogger {


    public XMLLoggerDecorator(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void info(String msg) {
        iLogger.info("xml:" + msg);
    }

    @Override
    public void error(String msg) {
        iLogger.error("xml:" + msg);
    }

    @Override
    public void warn(String msg) {
        iLogger.warn("xml:" + msg);
    }
}
