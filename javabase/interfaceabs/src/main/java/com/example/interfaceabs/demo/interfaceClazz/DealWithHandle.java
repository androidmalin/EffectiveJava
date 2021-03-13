package com.example.interfaceabs.demo.interfaceClazz;

public class DealWithHandle {
    public static <T> T handle(Fun<T> fun) {
        String request = fun.firstFunction();
        String response = fun.secondFunction(request);
        return fun.thirdFunction(response);
    }

    public interface Fun<T> {
        String firstFunction();

        String secondFunction(String requestText);

        T thirdFunction(String responseText);
    }
}


class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
}

class Test {
    public static void main(String[] args) {
        User user = DealWithHandle.<User>handle(new DealWithHandle.Fun<User>() {
            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String requestText) {
                return requestText.toLowerCase();
            }

            @Override
            public User thirdFunction(String responseText) {
                return new User(responseText);
            }
        });
        System.out.println(user.toString());
    }
}