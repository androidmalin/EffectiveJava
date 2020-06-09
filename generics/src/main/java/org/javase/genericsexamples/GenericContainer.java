package org.javase.genericsexamples;

/**
 * Generic Container
 * o<p>
 * 可以使用泛型开发一个更好的解决方案，在实例化时为所使用的容器分配一个类型，也称泛型类型，
 * 这样就可以创建一个对象来存储所分配类型的对象。
 * 泛型类型是一种类型参数化的类或接口，
 * <p>
 * 这意味着可以通过执行泛型类型调用 分配一个类型，将用分配的具体类型替换泛型类型。
 * 然后，所分配的类型将用于限制容器内使用的值，这样就无需进行类型转换，还可以在编译时提供更强的类型检查。
 * <p>
 * <p>
 * 最显著的差异是类定义包含 <T>，类字段 obj 不再是 Object 类型，而是泛型类型 T。
 * 类定义中的尖括号之间是类型参数部分，介绍类中将要使用的类型参数（或多个参数）。
 * T 是与此类中定义的泛型类型关联的参数。
 * 要使用泛型容器，必须在实例化时使用尖括号表示法指定容器类型。
 * <p>
 * 使用泛型的一些好处。一个最重要的好处是更强的类型检查，因为避开运行时可能引发的 ClassCastException 可以节省时间。
 * 另一个好处是消除了类型转换，这意味着可以用更少的代码，因为编译器确切知道集合中存储的是何种类型
 * <p>
 * <p>
 * 类签名包含一个类型参数部分，包括在类名后的尖括号 (< >) 内，例如：
 * <p>
 * 类型参数（又称类型变量）用作占位符，指示在运行时为类分配类型。根据需要，可能有一个或多个类型参数，并且可以用于整个类。
 * 根据惯例，类型参数是单个大写字母，该字母用于指示所定义的参数类型
 * <p>
 * T 指示将分配的类型，因此可在实例化时为 GenericContainer 分配任何有效类型。
 * 注意，T 参数用于整个类，指示实例化时指定的类型。
 * 使用下面这行代码实例化对象时，将用 String 类型替换所有 T 参数
 * GenericContainer<String> stringContainer = new GenericContainer<String>();
 *
 * @author Juneau
 */
public class GenericContainer<T> {
    private T obj;

    public GenericContainer() {
    }

    public GenericContainer(T t) {
        obj = t;
    }

    /**
     * get
     *
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * set
     *
     * @param t the obj to set
     */
    public void setObj(T t) {
        obj = t;
    }
}
