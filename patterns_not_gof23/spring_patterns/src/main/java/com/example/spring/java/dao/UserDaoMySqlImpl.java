package com.example.spring.java.dao;

public class UserDaoMySqlImpl implements IUserDao {
    @Override
    public void getUser() {
        System.out.println("mysql data");
    }
}
