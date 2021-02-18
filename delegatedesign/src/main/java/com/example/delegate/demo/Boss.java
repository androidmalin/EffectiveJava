package com.example.delegate.demo;

public class Boss {
    public void command(String task, Leader leader) {
        leader.doing(task);
    }
}
