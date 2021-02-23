package org.javase.genericsexamples.test;

import java.util.List;

public class GenericsInheritanceAndSubtypes {


    public static void main(String[] args) {

    }

    /**
     * 正如你已经知道的，只要类型兼容，就可以将一个类型的对象分配给另一个类型的对象。
     * 例如，你可以将一个Integer赋值给一个Object，因为Object是Integer的一个超类型。
     */
    private void test() {
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        someObject = someInteger;   // OK
    }

    /**
     * 在面向对象的术语中，这叫做 "是一种 "关系。由于Integer是Object的一种，所以允许赋值。
     * 但是Integer也是Number的一种，所以下面的代码也是有效的。
     */
    private void test1() {
        someMethod(new Integer(10));   //OK
        someMethod(new Double(10.1));   //OK
    }

    public void someMethod(Number n) {
        System.out.println(n);
    }

    /**
     * 对于泛型也是如此。你可以执行一个泛型调用，传递Number作为它的类型参数，
     * 如果参数与Number兼容，那么后续任何add的调用都将被允许。
     */
    private void test2() {
        Box<Number> box = new Box<>();
        box.add(new Integer(10));   // OK
        box.add(new Double(10.1));  // OK
    }

    public static class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }


    private void test3() {
        Box<Integer> integerBox = new Box<>();
    }

    /**
     * 它接受的参数类型是什么？
     * 通过查看它的签名，你可以看到它接受一个单一的参数，其类型是Box<Number>。
     * <p>
     * 但这意味着什么呢？
     * 你是否可以像你所期望的那样，传入Box<Integer>或Box<Double>？答案是 "不"。
     * 因为Box<Integer>和Box<Double>不是Box<Number>的子类型。
     * <p>
     * Box<Integer>不是Box<Number>的子类型，尽管Integer是Number的子类型。
     * <p>
     * 注意：给定两个具体类型A和B（例如Number和Integer），
     * MyClass<A>与MyClass<B>没有关系，不管A和B是否相关。
     * MyClass<A>和MyClass<B>的共同父类是Object。
     */
    public void boxTest(Box<Number> n) {

    }


    public void test4() {
        PayloadList<String, String> payloadList;
        PayloadList<String, Integer> payloadList1;
        PayloadList<String, Exception> payloadList2;
    }

    /**
     * 现在想象一下，我们想定义自己的列表接口PayloadList，
     * 它将一个通用类型P的可选值与每个元素关联起来。
     * 它的声明可能是这样的。
     */
    interface PayloadList<E, P> extends List<E> {
        void setPayload(int index, P val);
    }
}
