package com.example.decorator.pattern.log;

public interface ILogger {
    void info(String msg);

    void error(String msg);

    void warn(String msg);
}
