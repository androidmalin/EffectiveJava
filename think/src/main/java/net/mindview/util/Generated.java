package net.mindview.util;


import java.lang.reflect.Array;

/**
 * 为了接收Generator并产生数组，我们需要两个转换工具。
 * <p>
 * 第一个工具使用任意的Generator来产生Object子类型的数组。
 * <p>
 * 为了处理基本类型，第二个工具接收任意基本类型的包装器类型数组，并产生相应的基本类型数组。
 * <p>
 * 第一个工具有两种选项，并由重载的静态方法array()来表示。
 * <p>
 * 该方法的第一个版本接收一个已有的数组，并使用某个Generator来填充它，
 * <p>
 * 而第二个版本接收一个Class对象、一个Generator和所需的元素数量，
 * 然后创建一个新数组，并使用所接收的Generator来填充它。
 * <p>
 * 注意，这个工具只能产生Object子类型的数组，而不能产生基本类型数组：
 * <p>
 * <p>
 * CollectionData类将在第17章中定义，它将创建一个Collection对象，
 * 该对象中所填充的元素是由生成器gen产生的，
 * 而元素的数量则由构造器的第二个参数确定。
 * <p>
 * 所有的Collection子类型都拥有toArray()方法，该方法将使用Collection中
 * 的元素来填充参数数组。
 * <p>
 * 第二个方法使用反射来动态创建具有恰当类型和数量的新数组，
 * 然后使用与第一个方法相同的技术来填充该数组。
 */
public class Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<>(gen, size).toArray(a);
    }
}
