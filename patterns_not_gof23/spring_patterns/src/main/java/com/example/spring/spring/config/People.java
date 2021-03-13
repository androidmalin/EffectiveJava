package com.example.spring.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "people")
public class People {

    @Autowired
    Cat cat;

    @Resource
    Dog dog;

    public Cat getCat() {
        return cat;
    }

    public Dog getDog() {
        return dog;
    }

    @Override
    public String toString() {
        return "{"
                + " cat=" + cat.name +
                ", dog=" + dog.name +
                '}';
    }
}