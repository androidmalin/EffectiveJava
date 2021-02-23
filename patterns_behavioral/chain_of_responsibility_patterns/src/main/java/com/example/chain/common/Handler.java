package com.example.chain.common;

/**
 * 抽象处理者
 * 抽象处理者（Handler):
 * 定义一个请求处理的方法，并维护一个下一处理节点Handler对象的引用。
 */
public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler successor) {
        this.nextHandler = successor;
    }

    public abstract void handleRequest(String request);

}