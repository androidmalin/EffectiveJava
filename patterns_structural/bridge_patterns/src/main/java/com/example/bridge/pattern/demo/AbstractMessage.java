package com.example.bridge.pattern.demo;

import com.example.bridge.pattern.demo.message.IMessage;

public abstract class AbstractMessage {

    //持有一个实现部分的对象
    private final IMessage message;

    //构造方法,传入实现部分的对象
    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    //委派给实现部分的方法
    public void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }
}
