package com.example.interfaceabs.ex2;

class Test {
    public static void main(String[] args) {
        AbsHandler<User> absHandler = new AbsHandler<User>() {
            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String request) {
                return request.toLowerCase();
            }

            @Override
            public User thirdFunction(String response) {
                return new User(response);
            }
        };
        User user = absHandler.handle();
        System.out.println(user.name);
    }
}

public abstract class AbsHandler<T> {
    public String firstFunction() {
        throw new UnsupportedOperationException("must Override firstFunction()");
    }

    public String secondFunction(String request) {
        throw new UnsupportedOperationException("must Override secondFunction()");
    }

    public T thirdFunction(String response) {
        throw new UnsupportedOperationException("must Override thirdFunction()");
    }

    public final T handle() {
        String request = firstFunction();
        String response = secondFunction(request);
        return thirdFunction(response);
    }
}


class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
}