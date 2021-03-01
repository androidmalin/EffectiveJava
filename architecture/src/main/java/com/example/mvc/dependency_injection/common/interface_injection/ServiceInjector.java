package com.example.mvc.dependency_injection.common.interface_injection;

import java.util.HashSet;
import java.util.Set;

// Injector class
public class ServiceInjector {
    private final Set<ServiceSetter> clients = new HashSet<>();

    public void inject(ServiceSetter client) {
        clients.add(client);
        client.setService(new ServiceFoo());
    }

    public void switchToBar() {
        for (ServiceSetter client : clients) {
            client.setService(new ServiceBar());
        }
    }
}