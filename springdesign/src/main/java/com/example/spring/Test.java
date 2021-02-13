package com.example.spring;

import com.example.spring.dao.UserDaoOracleImpl;
import com.example.spring.service.UserServiceImpl;

public class Test {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
