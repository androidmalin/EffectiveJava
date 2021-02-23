package com.example.mediator.demo.chatroom;


public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("tom", chatRoom);
        User jake = new User("jake", chatRoom);

        tom.sendMessage("Hi! I am Tom.");
        jake.sendMessage("Hello! My name is jake.");
    }
}
