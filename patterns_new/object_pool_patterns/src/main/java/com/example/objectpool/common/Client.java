package com.example.objectpool.common;

public class Client {
    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(10, 50);

        IPooledObject object = pool.borrowObject();
        object.operation();

        pool.returnObject(object);
        System.out.println();
    }
}