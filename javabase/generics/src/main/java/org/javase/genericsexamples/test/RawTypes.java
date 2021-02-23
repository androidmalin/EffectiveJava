package org.javase.genericsexamples.test;

public class RawTypes {

    public static void main(String[] args) {

    }

    //parameterized:制定
    //parameterized:参数化
    //raw:原始
    //invoke:调用
    //generic:泛型
    //bypass:绕过了


    /**
     * assigning a parameterized type to its raw type is allowed:
     */
    @SuppressWarnings("rawtypes")
    private void assigningParameterizedTypeToRawType() {
        Box stringBox = new Box<String>();
        Box rawBox = stringBox;           // OK
    }


    /**
     * But if you assign a raw type to a parameterized type, you get a warning:
     */
    @SuppressWarnings("rawtypes")
    private void test() {
        Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion
    }


    /**
     * You also get a warning if you use a raw type to invoke generic methods defined in the corresponding generic type:
     * 如果使用原始类型调用在相应泛型类型中定义的泛型方法，也会得到警告:
     * <p>
     * The warning shows that raw types bypass generic type checks, deferring the catch of unsafe code to runtime.
     * Therefore, you should avoid using raw types.
     * 该警告表明，原始类型绕过了通用类型检查，将不安全代码的捕获推迟到运行时。因此，你应该避免使用原始类型。
     */
    @SuppressWarnings("rawtypes")
    private void rawTypeInvokeGenericMethod() {
        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;
        rawBox.set(8);  // warning: unchecked invocation to set(T)
    }

    /**
     * Type Erasure
     * 擦除类型
     * <p>
     * Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic programming.
     * 通用性被引入到Java语言中，以在编译时提供更严格的类型检查，并支持通用编程。
     * <p>
     * To implement generics, the Java compiler applies type erasure to:
     * 为了实现泛型，Java编译器将类型擦除应用于:
     * <p>
     * Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded.
     * 将通用类型中的所有类型参数用它们的边界来代替，如果类型参数是无边界的，则用Object来代替。
     * <p>
     * <p>
     * The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
     * 因此，产生的字节码只包含普通类、接口和方法。
     * <p>
     * Insert type casts if necessary to preserve type safety.
     * 如有必要，插入类型转换，以保持类型安全。
     * <p>
     * Generate bridge methods to preserve polymorphism in extended generic types.
     * 生成桥接方法以保存扩展通用类型的多态性。
     * <p>
     * Type erasure ensures that no new classes are created for parameterized types;
     * 类型擦除确保不会为参数化类型创建新的类。
     * <p>
     * consequently, generics incur no runtime overhead.
     * 因此，泛型不会产生运行时开销。
     */


    public static void yyyy() {
        Box<Integer> bi;
        bi = createBox();
    }

    static Box createBox() {
        return new Box();
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
