package com.example.chain.demo.optimization;

import com.example.chain.demo.bean.Member;

public abstract class Handler {
    protected Handler next;

    public void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);
}
