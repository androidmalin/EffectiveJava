package com.example.bridge.pattern;

/**
 * https://blog.csdn.net/pange1991/article/details/51146828
 */
public class Test {
    public static void main(String[] args) {
        ITV tv = new SonyTV();
        AbstractRemoteControl lrc = new LogitechRemoteControl(tv);
        lrc.turnOn();
        lrc.setChannel(100);
        lrc.turnOff();
    }
}
