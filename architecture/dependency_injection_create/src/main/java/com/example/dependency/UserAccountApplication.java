package com.example.dependency;

import com.example.dependency.application.CustomDemoApplication;
import com.example.dependency.di.framework.annotations.CustomApplication;

@CustomApplication
public class UserAccountApplication {

    public static void main(String[] args) {
        CustomDemoApplication.run(UserAccountApplication.class, args);
    }
}
