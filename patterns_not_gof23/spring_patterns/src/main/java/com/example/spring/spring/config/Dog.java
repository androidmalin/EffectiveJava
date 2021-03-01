package com.example.spring.spring.config;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    String name = "dogName";

    public void shout() {
        System.err.println("Dog shout!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}