package com.example.injection.interface_injection;

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

    @Override
    public String toString() {
        return "ServiceInjector{" +
                "clients=" + clients +
                '}';
    }
}