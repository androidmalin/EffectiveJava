package com.example.interfaceabs.demo.absClass;

public abstract class Template<T> {

    public abstract String firstFunction();

    public abstract String secondFunction(String request);

    public abstract T thirdFunction(String responseText);

    public final T handle() {
        String request = firstFunction();
        String response = secondFunction(request);
        return thirdFunction(response);
    }
}

