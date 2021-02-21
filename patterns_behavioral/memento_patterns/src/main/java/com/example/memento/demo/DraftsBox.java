package com.example.memento.demo;

import java.util.Stack;


public class DraftsBox {
    private final Stack<ArticleMemento> STACK = new Stack<>();

    public ArticleMemento getMemento() {
        return STACK.pop();
    }

    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }
}
