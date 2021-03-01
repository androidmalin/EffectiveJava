package com.malin.proxy.test.interface_test;

public class Client {

    public static void main(String[] args) {
        objInterfaceTest();
        interfaceInterfaceTest();
        arrayInterfaceTest();
    }

    private static void arrayInterfaceTest() {
        Integer[] arrayInt = new Integer[]{};
        Class<?>[] interfaces = arrayInt.getClass().getInterfaces();
        Class<?> interfaces0 = interfaces[0];
        Class<?> interfaces1 = interfaces[1];
        System.err.println("interfaces[0]:" + interfaces0);
        System.err.println("interfaces[1]:" + interfaces1);
    }

    private static void objInterfaceTest() {
        Shimmer s = new Shimmer();
        Class<?>[] interfaces = s.getClass().getInterfaces();
        Class<?> interfaces0 = interfaces[0];
        Class<?> interfaces1 = interfaces[1];
        Class<?> interfaces2 = interfaces[2];
        System.err.println("interfaces[0]:" + interfaces0.toString());
        System.err.println("interfaces[1]:" + interfaces1.toString());
        System.err.println("interfaces[2]:" + interfaces2.toString());
    }

    private static void interfaceInterfaceTest() {
        Class<?>[] interfaces = FloorWax.class.getInterfaces();
        Class<?> interfaces0 = interfaces[0];
        System.err.println("interfaces[0]:" + interfaces0.toString());
    }
}
