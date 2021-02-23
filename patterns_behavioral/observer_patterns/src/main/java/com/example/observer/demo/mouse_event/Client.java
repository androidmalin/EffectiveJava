package com.example.observer.demo.mouse_event;

import com.example.observer.demo.mouse_event.core.EventListener;
import com.example.observer.demo.mouse_event.handler.Mouse;
import com.example.observer.demo.mouse_event.handler.MouseEventListener;
import com.example.observer.demo.mouse_event.handler.MouseEventType;

public class Client {
    public static void main(String[] args) {
        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();
    }
}
