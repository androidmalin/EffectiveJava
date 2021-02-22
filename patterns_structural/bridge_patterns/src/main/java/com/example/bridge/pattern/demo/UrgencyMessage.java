package com.example.bridge.pattern.demo;

import com.example.bridge.pattern.demo.message.IMessage;

public class UrgencyMessage extends AbstractMessage {

    //构造方法,传入实现部分的对象
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "[加急]" + message;
        super.sendMessage(message, toUser);
    }
}
