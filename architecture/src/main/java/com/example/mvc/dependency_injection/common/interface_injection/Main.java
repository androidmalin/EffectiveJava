package com.example.mvc.dependency_injection.common.interface_injection;

public class Main {
    public static void main(String[] args) {
        ServiceInjector injector = new ServiceInjector();
        injector.inject(new Client());

        injector.switchToBar();
    }
}
