package com.example.spring.java;

import com.example.spring.java.dao.UserDaoMySqlImpl;
import com.example.spring.java.service.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMySqlImpl());
        userService.getUser();
    }
}
