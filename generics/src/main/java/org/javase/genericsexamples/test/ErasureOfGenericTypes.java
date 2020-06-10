package org.javase.genericsexamples.test;

public class ErasureOfGenericTypes {


    /**
     * 在类型擦除过程中，
     * 如果类型参数是有界的，Java编译器会擦除所有的类型参数，
     * 并以其第一个约束代替每个类型参数，
     * <p>
     * 如果类型参数是无界的，则以Object代替。
     * <p>
     * 考虑下面的通用类，它表示一个单链路列表中的节点。
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    /**
     * 因为类型参数T是无边界的，Java编译器用Object代替它。
     */
    public static class Node2 {
        private Object data;
        private Node2 next;

        public Node2(Object data, Node2 next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }


    /**
     * Node类使用了一个有界类型参数。
     */
    public class Node3<T extends Comparable<T>> {

        private T data;
        private Node3<T> next;

        public Node3(T data, Node3<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    /**
     * Java编译器将绑定类型参数T替换为第一个绑定类，Comparable。
     */
    public class Node4 {
        private Comparable data;
        private Node4 next;

        public Node4(Comparable data, Node4 next) {
            this.data = data;
            this.next = next;
        }

        public Comparable getData() {
            return data;
        }
    }


}