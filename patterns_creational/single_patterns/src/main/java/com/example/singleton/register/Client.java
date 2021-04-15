package com.example.singleton.register;

public class Client {
    public static void main(String[] args) {
        testEnum();
        testContainerSingleton();
    }

    private static void testContainerSingleton() {

        Util util = ContainerSingleton.getInstance(Util.class);
        util.log();

        Util util2 = (Util) ContainerSingleton.getInstance2(Util.class);
        util2.log();

    }

    private static void testEnum() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.setData("hello");
        Object data = instance.getData();
        System.out.println(data);
    }
}
