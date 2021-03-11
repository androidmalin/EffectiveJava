package com.example.injection.setter_injection;


import java.security.InvalidParameterException;

/**
 * Setter injection
 * This method requires the client to provide a setter method for the dependency.
 */
public class Client {
    // Internal reference to the service used by this client
    private Service service;

    // Setter method
    public void setService(Service service) {
        if (service == null) {
            throw new InvalidParameterException("service must not be null");
        }
        // Save the reference to the passed-in service inside this client.
        this.service = service;
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}

