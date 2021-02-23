package org.javase.genericsexamples.test;

public class BoundedTypeParameters {


    /**
     * 有界类型参数
     * 有时，您可能想限制可以作为参数化类型中的类型参数的类型，例如，对数字进行操作的方法可能只想接受Number或其子类的实例。
     * 例如，一个对数字进行操作的方法可能只想接受Number或其子类的实例。这就是有界类型参数的作用。
     * 要声明一个有界类型参数，请列出类型参数的名称，后面是extends关键字，然后是它的上界，在本例中是Number。
     * 请注意，在这里，extends在一般意义上是指 "扩展"（如类）或 "实现"（如接口）。
     */


    public static class Box<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

        public <U extends Number> void inspect(U u) {
            System.out.println("T: " + t.getClass().getName());
            System.out.println("U: " + u.getClass().getName());
        }
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        integerBox.inspect(10); // error: this is still String!
    }


    public class NaturalNumber<T extends Integer> {
        private T n;

        public NaturalNumber(T n) {
            this.n = n;
        }

        /**
         * 除了限制您可以用来实例化通用类型的类型之外，
         * 有界类型参数还允许您调用定义在边界中的方法。
         * n.intValue();
         * <p>
         * isEven方法通过n调用Integer类中定义的intValue方法。
         */
        public boolean isEven() {
            return n.intValue() % 2 == 0;
        }
    }

    /**
     * 多重界限
     * 前面的例子说明了使用单一边界的类型参数，但一个类型参数可以有多个边界。
     * <T extends B1 & B2 & B3>
     *
     * 一个有多个边界的类型变量是在边界中列出的所有类型的子类型。
     * 如果其中一个边界是一个类，必须先指定它。例如
     *
     * Class A {...}
     * interface B {...}
     * interface C {...}
     * class D <T extends A & B & C> {...}
     *
     * 如果没有先指定绑定A，你会得到一个编译时的错误。
     * class D <T extends B & A & C> {...}  // compile-time error
     */
}
