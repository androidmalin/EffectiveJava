package com.example.mvc.dependency_injection.common.setter_injection;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        Client client = new Client();
        client.setService(service);

        client.getName();
    }
}
