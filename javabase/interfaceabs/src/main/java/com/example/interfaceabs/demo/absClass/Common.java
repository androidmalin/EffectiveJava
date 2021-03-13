package com.example.interfaceabs.demo.absClass;

import com.example.interfaceabs.demo.Bean;

public class Common extends Template<Bean> {

    @Override
    public String firstFunction() {
        return "Java";
    }

    @Override
    public String secondFunction(String request) {
        return request.toLowerCase();
    }

    @Override
    public Bean thirdFunction(String responseText) {
        return new Bean(responseText);
    }

}
