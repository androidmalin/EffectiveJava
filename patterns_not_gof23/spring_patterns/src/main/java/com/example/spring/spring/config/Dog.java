package com.example.spring.spring.config;

import org.springframework.stereotype.Component;

/**
 * @Component （把普通POJO实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
 */
@Component
public class Dog {
    String name = "dogName";

    public void shout() {
        System.err.println("Dog shout!");
    }
}