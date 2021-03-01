package com.example.mvc.dependency_injection.common.constructor_injection;


import java.security.InvalidParameterException;

/**
 * Constructor injection
 * This method requires the client to provide a parameter in a constructor for the dependency.
 * <p>
 * 首选构造器注入的方式，
 * 因为它可以用于确保客户端对象始终处于有效状态，而不是使其某些依赖项引用为null（不设置）。
 * 但是，它本身缺乏灵活性，无法稍后更改其依赖项。
 */
public class Client {
    // Internal reference to the service used by this client
    private final Service service;

    // Constructor
    public Client(Service service) {
        if (service == null) {
            throw new InvalidParameterException("service must not be null");
        }
        // Save the reference to the passed-in service inside this client
        this.service = service;
    }

    public String greet() {
        return service.getName();
    }
}

