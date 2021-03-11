package com.example.injection.setter_injection;

public class Main {
    public static void main(String[] args) {

        Service service = new ExampleService();
        Client client = new Client();
        client.setService(service);

        System.err.println(client.greet());
    }
}
