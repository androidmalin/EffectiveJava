package com.example.chain.common;

/**
 * 具体处理者A
 * 具体处理者（ConcreteHandler):
 * 对请求进行处理，如果不感兴趣，则进行转发。
 */
public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("requestA".equals(request)) {
            System.out.println(this.getClass().getSimpleName() + "deal with request: " + request);
            return;
        }
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(request);
        }
    }
}