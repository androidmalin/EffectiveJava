package org.javase.genericsexamples.test;

public class Stack<E> {

    //用数组支持的泛型
    private E[] elements;

    private Object[] oo;

    @SuppressWarnings("unchecked")
    public Stack() {
        //不能创建不可具体化的类型数组。如E.
        //elements = new E[10];
        elements = (E[]) new Object[10];
    }

    public E pop() {
        E result = (E) oo[0];
        return result;
    }
}
