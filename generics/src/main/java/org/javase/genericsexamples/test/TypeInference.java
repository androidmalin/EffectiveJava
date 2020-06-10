package org.javase.genericsexamples.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
 * <p>
 * 类型推理是Java编译器查看每个方法调用和相应声明的能力，以确定使调用适用的类型参数（或参数）。
 * 推理算法确定参数的类型，如果有的话，确定结果被分配的类型，或返回的类型。
 * 最后，推理算法试图找到能与所有参数一起工作的最特定类型。
 */
public class TypeInference {

    static <T> T pick(T a1, T a2) {
        return a2;
    }

    /**
     * 为了说明最后一点，在下面的示例中，推论确定传递给pick方法的第二个参数的类型为Serializable：
     */
    private void test() {
        Serializable s = pick("d", new ArrayList<String>());
    }


    /**
     * 泛型方法向您介绍了类型推理，它使您能够像调用普通方法一样调用通用方法，而无需在角括号之间指定类型。
     * 考虑下面的例子，BoxDemo，它需要Box类。
     * <p>
     * <p>
     * 泛型方法addBox定义了一个名为U的类型参数。
     * 一般来说，Java编译器可以推断出一个泛型方法调用的类型参数。
     * 因此，在大多数情况下，你不必指定它们。例如，要调用泛型方法addBox。
     * 你可以用类型见证 来 指定类型参数，如下所示。
     * BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
     * <p>
     * 另外，如果你省略了类型见证，Java编译器会自动推断（从方法的参数中）类型参数是Integer。
     * BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
     * <p>
     * <p>
     * 泛型类的类型推断和实例化
     * 只要编译器能从上下文中推断出类型参数，就可以用一组空的类型参数（<>）代替调用泛型类的构造函数所需的类型参数。
     * 这对角括号被非正式地称为钻石。
     * Map<String, List<String>> myMap = new HashMap<String, List<String>>();
     * 你可以用一组空的类型参数（<>）代替构造函数的参数化类型。
     * Map<String, List<String>> myMap = new HashMap<>();
     */
    public static void main(String[] args) {
        ArrayList<BoxDemo.Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        BoxDemo.<Integer>addBox(10, listOfIntegerBoxes);
        BoxDemo.addBox(20, listOfIntegerBoxes);
        BoxDemo.addBox(30, listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);


    }

    public static class BoxDemo {
        public static <U> void addBox(U u, List<Box<U>> boxes) {
            Box<U> box = new Box<>();
            box.set(u);
            boxes.add(box);
        }

        public static <U> void outputBoxes(List<Box<U>> boxes) {
            int counter = 0;
            for (Box<U> box : boxes) {
                U boxContents = box.get();
                System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
                counter++;
            }
        }

        public static class Box<T> {
            private T t;

            public void set(T t) {
                this.t = t;
            }

            public T get() {
                return t;
            }
        }
    }


    /**
     * 该语句创建了一个参数化类型MyClass<Integer>的实例。
     * 该语句明确指定了泛型类MyClass<X>的形式化类型参数X的类型为Integer。
     * <p>
     * 请注意，这个泛型类的构造函数包含一个形式化类型参数T。
     * 编译器为这个泛型类的构造函数的形式类型参数T推导出类型为String（因为这个构造函数的实际参数是一个String对象）。
     */
    public static void test2() {
        new MyClass<Integer>("hello");

        //在这个例子中，编译器为泛型类MyClass<X>的形式类型参数X推断出Integer类型。
        //它为这个泛型类的构造函数的形式化类型参数T推导出String类型。
        MyClass<Integer> myObject = new MyClass<Integer>("");
    }

    public static class MyClass<X> {
        public <T> MyClass(T t) {
            // ...
        }
    }


    public static void test3() {
        List<String> list = Collections.emptyList();
        //这条语句期望得到一个List<String>的实例；这个数据类型是目标类型。
        //因为方法 emptyList 返回一个类型为 List<T> 的值，编译器推断类型参数 T 必须是值 String。这在Java SE 7和8中都适用。
        //另外，您也可以使用类型见证并指定T的值，如下所示。然而，在这种情况下没有必要这样做。
        List<String> listOne = Collections.<String>emptyList();
    }

    public static void test4() {
        processStringList(Collections.emptyList());
    }

    public static void processStringList(List<String> stringList) {
        // process stringList
    }
}
