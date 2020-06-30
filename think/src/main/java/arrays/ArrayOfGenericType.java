package arrays;

// Arrays of generic types won't compile.
public class ArrayOfGenericType<T> {
    T[] array; // OK


    /**
     * 擦除再次成为了障碍, 本例试图创建的类型已被擦除，因而是类型未知的数组。
     * <p>
     * 注意，你可以创建Object数组，然后将其转型，但是如果没有
     *
     * @ SuppressWarnings注解，你将在编译期得到一个"不受检查"的警告消息，
     * <p>
     * 因为这个数组没有真正持有或动态检查类型T。
     * <p>
     * 也就是说，如果我创建一个String[],Java在编译期和运行时都会强制要求我只能将String对象置于该数组中。
     * <p>
     * 但是，如果创建的是Object[],那么我就可以将除基本类型之外的任何对象置于该数组中。
     * <p>
     * 重点理解
     */
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //! array = new T[size]; // Illegal
        array = (T[]) new Object[size]; // "unchecked" Warning
    }
    // Illegal:
    //! public <U> U[] makeArray() { return new U[10]; }
}