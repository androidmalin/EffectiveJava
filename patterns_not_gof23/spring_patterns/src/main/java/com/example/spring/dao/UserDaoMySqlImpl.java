package com.example.spring.dao;

public class UserDaoMySqlImpl implements IUserDao {
    @Override
    public void getUser() {
        System.out.println("mysql data");
    }
}
