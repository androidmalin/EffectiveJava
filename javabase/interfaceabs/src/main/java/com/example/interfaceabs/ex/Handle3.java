package com.example.interfaceabs.ex;

class Test3 {
    public static void main(String[] args) {
        User3 user3 = HandleWrapper.handle(new Handle3<User3>() {
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

public interface Handle3<T> {

    String firstFunction();

    String secondFunction(String request);

    T thirdFunction(String response);
}

class HandleWrapper {
    public static <T> T handle(Handle3<T> fun) {
        String request = fun.firstFunction();
        String response = fun.secondFunction(request);
        return fun.thirdFunction(response);
    }
}

class User3 {
    public String name;

    public User3(String name) {
        this.name = name;
    }
}