package org.javase.genericsexamples.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个 "In "变量
 * 一个 "in "变量为代码提供数据。想象一下，一个复制方法有两个参数：copy(src, dest)。src参数提供了要复制的数据，所以它是 "in "参数。
 * <p>
 * 一个 "输出 "变量
 * 一个 "out "变量用来保存数据，以便在其他地方使用。在复制的例子中，copy(src, dest)，dest参数接受数据，所以它是 "out "参数。
 * <p>
 * 当然，有些变量既用于 "in "又用于 "out"--这种情况在指南中也有涉及。
 * 在决定是否使用通配符以及什么类型的通配符合适时，可以使用 "入 "和 "出 "原则。下面的列表提供了可遵循的准则。
 * <p>
 * 通配符准则。
 * 一个 "in "变量是用上界通配符定义的，使用extends关键字。
 * 在 "in "变量中，使用extends关键字定义了一个有下限的通配符，而在 "out "变量中，使用了super关键字定义了一个下限的通配符。
 * 在 "in "变量可以使用Object类中定义的方法来访问的情况下，使用无界通配符。
 * 在代码需要同时作为 "in "和 "out "变量访问的情况下，不要使用通配符。
 */
public class GuidelinesForWildcardUse {


    /**
     * 因为List<EvenNumber>是List<? extends NaturalNumber>的一个子类型，所以你可以将le赋值给ln。
     * <p>
     * 但不能用ln将自然数添加到偶数列表中。可以对列表进行以下操作。
     * <p>
     * 你可以添加null
     * 你可以调用clear。
     * 你可以获取迭代器并调用移除。
     * 你可以获取通配符，并写入从列表中读取的元素。
     * 你可以看到，List<? extends NaturalNumber>定义的列表并不是最严格意义上的只读，但你可能会这样想，因为你不能在列表中存储一个新元素或改变一个现有元素。
     */
    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
        ln.clear();
        //ln.add(new NaturalNumber(35));  // compile-time error
    }

    public static class NaturalNumber {
        private int i;

        public NaturalNumber(int i) {
            this.i = i;
        }
    }

    public static class EvenNumber extends NaturalNumber {
        public EvenNumber(int i) {
            super(i);
        }
    }

}
