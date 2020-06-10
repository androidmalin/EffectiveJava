package org.javase.genericsexamples.test;

import java.util.Arrays;
import java.util.List;

public class WildcardCaptureAndHelperMethods {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        WildcardFixed.foo(list);
    }


    /**
     * 在本例中，编译器将i输入参数处理为Object类型。
     * 当foo方法调用List.set(int, E)时，编译器无法确认插入列表中的对象类型，于是产生了一个错误。
     * 当这种类型的错误发生时，通常意味着编译器认为你给一个变量分配了错误的类型。
     * 为此，Java语言中加入了通用性--在编译时强制执行类型安全。
     */
    public static class WildcardError {
        void foo(List<?> i) {
            //i.set(0, i.get(0));//error
        }
    }

    public static class WildcardFixed {
        public static void foo(List<?> i) {
            fooHelper(i);
        }

        /**
         * 你可以通过编写一个私有助记符方法来解决这个问题，这个方法可以捕获通配符。
         * 在这种情况下，你可以通过创建私有的帮助者方法fooHelper来绕过这个问题，如WildcardFixed所示。
         * 创建辅助方法，以便通过类型推理捕获通配符。
         */
        // Helper method created so that the wildcard can be captured through type inference.
        private static <T> void fooHelper(List<T> l) {
            l.set(0, l.get(0));
        }
    }


}
