package com.example.spring.service;

import com.example.spring.dao.IUserDao;

public class UserServiceImpl implements IUserService {

    private com.example.spring.dao.IUserDao IUserDao;

    public void setUserDao(IUserDao IUserDao) {
        this.IUserDao = IUserDao;
    }

    @Override
    public void getUser() {
        IUserDao.getUser();
    }
}
