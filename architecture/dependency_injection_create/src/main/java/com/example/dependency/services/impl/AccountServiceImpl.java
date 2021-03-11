package com.example.dependency.services.impl;

import com.example.dependency.di.framework.annotations.CustomComponent;
import com.example.dependency.services.AccountService;

@CustomComponent
public class AccountServiceImpl implements AccountService {

    @Override
    public Long getAccountNumber(String userName) {
        return 12345689L;
    }
}
