package com.example.uml.combination;

public class Human {

    //头属于人的一部分,和人具有相同的声明周期
    private Head head;

    //身体属于人的一部分,和人具有相同的声明周期
    private Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void display() {

    }
}
