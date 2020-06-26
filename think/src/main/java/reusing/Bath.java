package reusing;

import static net.mindview.util.Print.print;

// Constructor initialization with composition.
class Soap {
    private String s;

    Soap() {
        print("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}


/**
 * 正如我们在第2章中所提到的，类中域为基本类型时能够自动被初始化为零。
 * 但是对象引用会被初始化为null,而且如果你试图为它们调用任何方法，都会得到
 * 一个异常一运行时错误。
 * <p>
 * 很方便的是，在不抛出异常的情况下仍旧可以打印一个null引用。
 * <p>
 * 编译器并不是简单地为每一个引用都创建默认对象，这一点是很有意义的，
 * 因为若真要那样做的话，就会在许多情况下增加不必要的负担。
 * <p>
 * 如果想初始化这些引用，可以在代码中的下列位置进行：
 * <p>
 * 1. 在定义对象的地方。这意味着它们总是能够在构造器被调用之前被初始化。
 * 2. 在类的构造器中。
 * 3. 就在正要使用这些对象之前，这种方式称为惰性初始化。
 * 在生成对象不值得及不必每次都生成对象的情况下，这种方式可以减少额外的负担。
 * 4. 使用实例初始化。
 * 以下是这四种方式的示例：
 */
public class Bath {
    private String // Initializing at point of definition:
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    public Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // Instance initialization:
    {
        i = 47;
    }

    @Override
    public String toString() {
        if (s4 == null) // Delayed initialization:
            s4 = "Joy";
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        print(b);
    }
}
