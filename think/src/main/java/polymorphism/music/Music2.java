package polymorphism.music;

import static net.mindview.util.Print.print;

class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        print("Stringed.play() " + n);
    }
}

class Brass extends Instrument {
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }
}

public class Music2 {

    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Brass i) {
        i.play(Note.MIDDLE_C);
    }

    /**
     * Music.java看起来似乎有些奇怪。为什么所有人都故意忘记对象的类型呢？
     * 在进行向上转型时，就会产生这种情况；
     * <p>
     * 并且如果让tune()方法直接接受一个Wind引用作为自己的参数，似乎会更为直观。
     * <p>
     * 但这样引发的一个重要问题是：
     * 如果那样做，就需要为系统内Instrument的每种类型都编写一个新的tune()方法。
     * <p>
     * 假设按照这种推理，现在再加入stringed（弦乐）和Brass（管乐）这两种
     * <p>
     * 这样做行得通，但有一个主要缺点：必须为添加的每一个新Instrument类编写定类型的方法。
     * <p>
     * 这意味着在开始时就需要更多的编程，这也意味着如果以后想添加类似tune()的新方法，
     * 或者添加自Instrument导出的新类，仍需要做大量的工作。
     * <p>
     * 此外，如果我们忘记重载某个方法，编译器不会返回任何错误信息，这样关于类型的整个处理过程就变得难以操纵。
     * 如果我们只写这样一个简单方法，它仅接收基类作为参数，而不是那些特殊
     * 的导出类。
     * <p>
     * 这样做情况会变得更好吗？也就是说，如果我们不管导出类的存在，编写的代码只是与基类打交道，会不会更好呢？
     * 这正是多态所允许的。
     * <p>
     * 然而，大多数程序员具有面向过程程序设计的背景，对多态的运作方式可能会有一点迷惑。
     * <p>
     * <p>
     * 方法调用绑定
     * 将一个方法调用同一个方法主体关联起来被称作绑定。
     * 若在程序执行前进行绑定（如果有的话，由编译器和连接程序实现），叫做前期绑定。
     * <p>
     * 读者可能以前从来没有听说过这个术语，因为它是面向过程的语言中不需要选择就默认的绑定方式。
     * <p>
     * 例如，C只有一种方法调用，那就是前期绑定。
     * <p>
     * 上述程序之所以令人迷惑，主要是因为前期绑定。
     * <p>
     * 因为，当编译器只有一个Instrument引用时，它无法知道究竟调用哪个方法才对。
     * <p>
     * 解决的办法就是后期绑定，它的含义就是在运行时根据对象的类型进行绑定。
     * <p>
     * 后期绑定也叫做动态绑定或运行时绑定。
     * <p>
     * 如果一种语言想实现后期绑定，就必须具有某种机制，以便在运行时能判断对象的类型，从而调用恰当的方法。
     * <p>
     * 也就是说，编译器一直不知道对象的类型，但是方法调用机制能找到正确的方法体，并加以调用。
     * <p>
     * 后期绑定机制随编程语言的不同而有所不同，但是只要想一下
     * <p>
     * 就会得知，不管怎样都必须在对象中安置某种"类型信息"
     * <p>
     * Java中除了static方法和final法(private方法属于final法）之外，其他所有的方法都是后期绑定。
     * <p>
     * 这意味着通常情况下，我们不必判定是否应该进行后期绑定它会自动发生。
     * <p>
     * 为什么要将某个方法声明为final呢？正如前一章提到的那样，它可以防止其他人覆盖该方法。
     * <p>
     * 但更重要的一点或许是：这样做可以有效地"关闭"动态绑定，
     * <p>
     * 或者说，告诉编译器不需要对其进行动态绑定。
     * <p>
     * 这样，编译器就可以为final方法调用生成更有效的代码。
     * <p>
     * 然而，大多数情况下，这样做对程序的整体性能不会有什么改观。
     * <p>
     * 所以，最好根据设计来决定是否使用final，而不是出于试图提高性能的目的来使用final。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute); // No upCasting
        tune(violin);
        tune(frenchHorn);
    }
}