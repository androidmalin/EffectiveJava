package com.example.proxy.common;

/**
 * 代理主题角色
 */
public class Proxy implements ISubject {

    private final ISubject subject;

    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before() {
        System.out.println("called before request().");
    }

    public void after() {
        System.out.println("called after request().");
    }
}