package polymorphism;

import static net.mindview.util.Print.print;

// Constructors and polymorphism
// don't produce what you might expect.
class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

/**
 * 构造器调用的层次结构带来了一个有趣的两难问题。如果在一个构造器的内
 * 部调用正在构造的对象的某个动态绑定方法，那会发生什么情况呢？
 * <p>
 * <p>
 * 在一般的方法内部，动态绑定的调用是在运行时才决定的，因为对象无法知
 * 道它是属于方法所在的那个类，还是属于那个类的导出类。
 * <p>
 * 如果要调用构造器内部的一个动态绑定方法，就要用到那个方法的被覆盖后的定义。
 * <p>
 * 然而，这个调用的效果可能相当难于预料，因为被覆盖的方法在对象被完全构造之前就会被调用。
 * <p>
 * 这可能会造成一些难于发现的隐臧错误。
 * <p>
 * 从概念上讲，构造器的工作实际上是创建对象（这并非是一件平常的工作）。
 * <p>
 * 在任何构造器内部，整个对象可能只是部分形成一我们只知道基类对象已经进行初始化。
 * <p>
 * 如果构造器只是在构建对象过程中的一个步骤，并且该对象所
 * 属的类是从这个构造器所属的类导出的，
 * <p>
 * 那么导出部分在当前构造器正在被调用的时刻仍旧是没有被初始化的。
 * <p>
 * 然而，一个动态绑定的方法调用却会向外深入到继承层次结构内部，它可以调用导出类里的方法。
 * <p>
 * 如果我们是在构造器内部这样做，那么就可能会调用某个方法，而这个方法所操纵的成员可能还未进行初始化
 * 这肯定会招致灾难。
 * <p>
 * 通过下面这个例子，我们会看到问题所在：
 * <p>
 * Glyph.draw()方法设计为将要被覆盖，这种覆盖是在RoundGlyph中发生的。
 * <p>
 * 但是Glyph构造器会调用这个方法，结果导致了对RoundGlyph.draw()的调用，这看起来似乎是我们的目的。
 * <p>
 * 但是如果看到输出结果，我们会发现当Glyph的构造器调用draw()方法时，
 * radius不是默认初始值1，而是0。
 * <p>
 * 这可能导致在屏幕上只画了一个点或者根本什么东西都没有；
 * <p>
 * 我们只能干瞪眼，并试图找出程序无法运转的原因所在。
 * <p>
 * <p>
 * <p>
 * <p>
 * ************
 * <p>
 * 前一节讲述的初始化顺序并不十分完整，而这正是解决这一谜题的关键所在。
 * <p>
 * 初始化的实际过程是：
 * 1. 在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的0
 * 2. 如前所述那样调用基类构造器。此时，调用被覆盖后的draw()方法
 * （要在调用RoundGlyph构造器之前调用），由于步骤1的缘故，我们此时会发现radius的值为0。
 * 3. 按照声明的顺序调用成员的初始化方法。
 * 4. 调用导出类的构造器主体。
 * <p>
 * <p>
 * 这样做有一个优点,那就是所有东西都至少初始化成零
 * （或者是某些特殊数据类型中与"零"等价的值），而不是仅仅留作垃圾。
 * <p>
 * 其中包括通过"组合"而嵌入一个类内部的对象引用，其值是null。
 * <p>
 * 所以如果忘记为该引用进行初始化，就会在运行时出现异常。
 * <p>
 * 查看输出结果时，会发现其他所有东西的值都会是零，这通常也正是发现问题的证据。
 * <p>
 * 另一方面，我们应该对这个程序的结果相当震惊。
 * <p>
 * 在逻辑方面，我们做的已经十分完美，而它的行为却不可思议地错了，并且编译器也没有报错。
 * （在这种情况下，C++语言会产生更合理的行为。）
 * <p>
 * 诸如此类的错误会很容易被人忽略，而且要花很长的时间才能发现。
 * <p>
 * 因此，编写构造器时有一条有效的准则："用尽可能简单的方法使对象进入正常状态；如果可以的话，避免调用其他方法"。
 * <p>
 * 在构造器内唯一能够安全调用的那些方法是基类中的final方法
 * （也适用于private方法，它们自动属于final方法）
 * <p>
 * 这些方法不能被覆盖，因此也就不会出现上述令人惊讶的问题。
 * 你可能无法总是能够遵循这条准则，但是应该朝着它努力。
 * <p>
 * 重点关注
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}