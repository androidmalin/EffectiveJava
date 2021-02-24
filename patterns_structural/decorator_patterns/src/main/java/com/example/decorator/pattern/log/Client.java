package com.example.decorator.pattern.log;

/**
 * 装饰者模式,直接看书 设计模式就该这么学
 * <p>
 * 别看尚学堂的视频,那个没有解释清楚.浪费时间.
 */
public class Client {

    public static void main(String[] args) {
        ILogger iLogger = new Logger();
        ILogger jsonLoggerDecorator = new JsonLoggerDecorator(iLogger);

        ILogger xmlLoggerDecorator = new XMLLoggerDecorator(jsonLoggerDecorator);
        xmlLoggerDecorator.info("xxx");

        ILogger iLogger2 = new JsonLogger2(new Logger());
        iLogger2.info("xxx2");
    }
}
