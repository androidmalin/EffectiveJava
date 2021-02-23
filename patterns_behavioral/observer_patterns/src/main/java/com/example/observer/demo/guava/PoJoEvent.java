package com.example.observer.demo.guava;

import com.google.common.eventbus.Subscribe;

@SuppressWarnings("UnstableApiUsage")
public class PoJoEvent {

    @Subscribe
    public void observer(Object arg) {
        if (arg instanceof PoJo) {
            System.out.println("执行PoJoEvent方法，传参为：" + arg);
        }
    }
}
