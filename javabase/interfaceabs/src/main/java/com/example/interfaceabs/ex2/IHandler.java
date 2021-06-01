package com.example.interfaceabs.ex2;

class Test3 {
    public static void main(String[] args) {
        User3 user3 = HandlerWrapper.handle(new IHandler<User3>() {
            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String request) {
                return request.toLowerCase();
            }

            @Override
            public User3 thirdFunction(String response) {
                return new User3(response);
            }
        });
        System.out.println(user3.name);
    }
}

public interface IHandler<T> {

    String firstFunction();

    String secondFunction(String request);

    T thirdFunction(String response);
}

class HandlerWrapper {
    public static <T> T handle(IHandler<T> iHandler) {
        String request = iHandler.firstFunction();
        String response = iHandler.secondFunction(request);
        return iHandler.thirdFunction(response);
    }
}

class User3 {
    public String name;

    public User3(String name) {
        this.name = name;
    }
}