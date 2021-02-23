package com.example.observer.demo.guava;

import com.google.common.eventbus.EventBus;


public class Client {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        PoJoEvent guavaEvent = new PoJoEvent();
        VoEvent voEvent = new VoEvent();
        eventBus.register(guavaEvent);
        eventBus.register(voEvent);

        eventBus.post(new PoJo("PoJo"));
        eventBus.post(new Vo("Vo"));
    }
}
