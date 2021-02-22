package com.example.bridge.pattern.demo;

import com.example.bridge.pattern.demo.message.EmailMessage;
import com.example.bridge.pattern.demo.message.IMessage;
import com.example.bridge.pattern.demo.message.SmsMessage;
import com.example.bridge.pattern.demo.message.SystemMessage;

/**
 * 采用桥接模式解耦了"消息类型"和"消息紧急程度"这两个独立变化的维度。
 * <p>
 * 后续如果有更多的消息类型，比如微信、钉钉等，则直接新建一个类继承IMessage即可；
 * <p>
 * 如果紧急程度需要新增，则同样只需新建一个类实AbstractMessage类即可。
 */
public class Client {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage(" 加班申请 ", "王总");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage(" 加班申请 ", "王总");

        message = new SystemMessage();
        abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage(" 加班申请 ", "王总");
    }

}
