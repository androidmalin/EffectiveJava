package com.example.spring.java.service;

import com.example.spring.java.dao.IUserDao;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao IUserDao) {
        this.userDao = IUserDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
