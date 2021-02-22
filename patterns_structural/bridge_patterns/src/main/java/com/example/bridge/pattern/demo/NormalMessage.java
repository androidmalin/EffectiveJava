package com.example.bridge.pattern.demo;

import com.example.bridge.pattern.demo.message.IMessage;

public class NormalMessage extends AbstractMessage {

    //构造方法,传入实现部分的对象
    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
