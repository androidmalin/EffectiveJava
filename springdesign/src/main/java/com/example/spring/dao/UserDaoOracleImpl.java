package com.example.spring.dao;

public class UserDaoOracleImpl implements IUserDao {
    @Override
    public void getUser() {
        System.out.println("oracle data");
    }
}
