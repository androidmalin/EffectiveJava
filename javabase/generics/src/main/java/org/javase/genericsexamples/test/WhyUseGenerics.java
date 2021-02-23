package org.javase.genericsexamples.test;

import java.util.ArrayList;
import java.util.List;

public class WhyUseGenerics {

    public static void main(String[] args) {

    }

    /**
     * 为什么要使用泛型？
     * 简而言之，泛型在定义类，接口和方法时使类型（类和接口）成为参数。
     * 与方法声明中使用的更熟悉的形式参数非常相似，类型参数为您提供了一种使用不同输入重复使用相同代码的方法。
     * 区别在于形式参数的输入是值，而类型参数的输入是类型。
     * 与非泛型代码相比，使用泛型的代码具有许多优点：
     * 在编译时进行更强的类型检查。
     * Java编译器对通用代码进行强类型检查，如果代码违反类型安全，则会发出错误。
     * 修复编译时错误比修复运行时错误容易，后者可能很难找到。
     */
    private void withoutGenericsRequiresCasting() {
        //The following code snippet without generics requires casting:
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);
        System.out.println(s);
    }

    /**
     * When re-written to use generics, the code does not require casting:
     */
    private void generic() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        String s = list.get(0);   // no cast
        System.out.println(s);
    }
}
