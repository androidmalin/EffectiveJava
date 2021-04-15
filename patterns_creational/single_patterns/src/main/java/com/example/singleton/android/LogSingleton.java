package com.example.singleton.android;

public class LogSingleton extends Singleton<Log> {
    @Override
    public Log create() {
        return new Log();
    }
}
