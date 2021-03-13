package com.example.dependency.services.impl;

import com.example.dependency.di.framework.annotations.CustomComponent;
import com.example.dependency.services.UserService;

@CustomComponent
public class UserServiceImpl2 implements UserService {

    @Override
    public String getUserName() {
        return "user222";
    }
}
