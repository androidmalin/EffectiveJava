package com.example.dependency.application;

import com.example.dependency.di.framework.annotations.CustomAutowired;
import com.example.dependency.di.framework.annotations.CustomComponent;
import com.example.dependency.di.framework.annotations.CustomQualifier;
import com.example.dependency.services.AccountService;
import com.example.dependency.services.UserService;

/**
 * Client class, havin userService and accountService expected to initialized by
 * CustomInjector.java
 */
@CustomComponent
public class ClientApplication {

    @CustomAutowired
    @CustomQualifier(value = "UserServiceImpl2")
    private UserService userService;

    @CustomAutowired
    @CustomQualifier(value = "AccountServiceImpl2")
    private AccountService accountService;

    public void displayUserAccount() {

        String username = userService.getUserName();

        Long accountNumber = accountService.getAccountNumber(username);

        System.out.println("\nUser Name: " + username + "; Account Number: " + accountNumber);
    }
}
