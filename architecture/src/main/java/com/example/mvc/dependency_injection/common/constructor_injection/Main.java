package com.example.mvc.dependency_injection.common.constructor_injection;

public class Main {
    public static void main(String[] args) {
        // Build the dependencies first
        Service service = new ExampleService();

        // Inject the service, constructor style
        Client client = new Client(service);

        // Use the objects
        System.err.println(client.greet());
    }
}
