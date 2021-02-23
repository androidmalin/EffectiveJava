package com.example.chain.common;


/**
 * （1）抽象处理者（Handler):定义一个请求处理的方法，并维护一个下一处理节点Handler对象的引用。
 * （2）具体处理者（ConcreteHandler):对请求进行处理，如果不感兴趣，
 * 则进行转发。
 * 责任链模式的本质是解耦请求与处理，让请求在处理链中能进行传递与被处理；
 * 理解责任链模式应当理解的是其模式而不是其具体实现，
 * <p>
 * 责任链模式的独到之处是其将节点处理者组合成了链式结构，
 * 并允许节点自身决定是否进行请求处理或转发，相当于让请求流动起来。
 */
public class Client {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);
        handlerA.handleRequest("requestB");
    }
}
