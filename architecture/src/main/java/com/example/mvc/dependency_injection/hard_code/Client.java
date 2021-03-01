package com.example.mvc.dependency_injection.hard_code;

/**
 * dependency injection
 * 在以下Java示例中，Client类包含一个Service成员变量，该变量由Client构造函数初始化。
 * 客户端控制使用哪种服务实现并控制其构造。
 * 在这种情况下，称为Client对ExampleService具有硬编码依赖性。
 */
// An example without dependency injection
public class Client {
    // Internal reference to the service used by this client
    private final ExampleService service;

    // Constructor
    public Client() {
        // Specify a specific implementation in the constructor instead of using dependency injection
        service = new ExampleService();
    }

    // Method within this client that uses the services
    public String greet() {
        return "Hello " + service.getName();
    }
}

