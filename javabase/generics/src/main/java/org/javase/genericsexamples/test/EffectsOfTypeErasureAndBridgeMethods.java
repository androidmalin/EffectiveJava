package org.javase.genericsexamples.test;


/**
 * 类型擦除和桥接方法的影响
 * 有时，类型擦除会造成你可能没有预料到的情况。
 * 下面的例子说明了这种情况是如何发生的。
 * 这个例子（在桥接方法中描述）显示了编译器有时如何创建一个合成方法，称为桥接方法，作为类型擦除过程的一部分。
 */
public class EffectsOfTypeErasureAndBridgeMethods {


    /**
     * n.setData("Hello");
     * 导致方法setData(Object)在MyNode类的对象上执行。
     * (MyNode类从Node继承了setData(Object)。)
     * <p>
     * 在setData(Object)的主体中，n所引用的对象的数据字段被分配给一个String。
     * <p>
     * 通过mn引用的同一个对象的数据字段可以被访问，并且被期望是一个整数
     * （因为mn是一个MyNode，而MyNode是一个Node<Integer>。
     * <p>
     * 试图将一个字符串赋值给一个整数，会导致Java编译器在赋值处插入的一个铸型异常ClassCastException。
     */
    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data;    // Causes a ClassCastException to be thrown.


        //After type erasure, this code becomes:
        MyNode mn2 = new MyNode(5);
        Node n2 = (MyNode) mn2;         // A raw type - compiler throws an unchecked warning
        n2.setData("Hello");
        //Integer x2 = (String) mn2.data; // Causes a ClassCastException to be thrown.
    }

    public static class Node<T> {
        public T data;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    public static class MyNode extends Node<Integer> {
        public MyNode(Integer data) {
            super(data);
        }

        @Override
        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }

}
