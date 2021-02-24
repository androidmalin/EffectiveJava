package com.example.bridge.pattern.demo.message;

public interface IMessage {
    /**
     * 发送消息的内容和接收人
     *
     * @param message 发送消息的内容
     * @param toUser  接收人
     */
    void send(String message, String toUser);
}
