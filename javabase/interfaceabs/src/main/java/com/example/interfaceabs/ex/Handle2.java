package com.example.interfaceabs.ex;

class Test2 {
    public static void main(String[] args) {
        Handle2<User2> handle2 = new Handle2<User2>() {

            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String request) {
                return request.toLowerCase();
            }

            @Override
            public User2 thirdFunction(String response) {
                return new User2(response);
            }
        };
        User2 user = handle2.handle();
        System.out.println(user.name);
    }
}

public abstract class Handle2<T> {

    public abstract String firstFunction();

    public abstract String secondFunction(String request);

    public abstract T thirdFunction(String response);

    public final T handle() {
        String request = firstFunction();
        String response = secondFunction(request);
        return thirdFunction(response);
    }
}

class User2 {
    public String name;

    public User2(String name) {
        this.name = name;
    }
}