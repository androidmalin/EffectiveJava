package com.example.mediator.demo.chatroom;


public class User {
    private final String name;
    private final ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        this.chatRoom.showMsg(this, msg);
    }
}
