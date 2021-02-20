package com.example.proxy.gpproxy.client;


public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        ITeacher teacher = factory.getInstance(new Teacher());
        teacher.teach();
    }
}
