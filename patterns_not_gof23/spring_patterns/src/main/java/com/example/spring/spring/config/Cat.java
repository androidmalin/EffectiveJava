package com.example.spring.spring.config;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    public String name = "catName";

    public void shout() {
        System.err.println("Cat shout!");
    }

}