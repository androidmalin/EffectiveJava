package reusing;

import static net.mindview.util.Print.print;

class Shape {
    Shape(int i) {
        print("Shape constructor");
    }

    void dispose() {
        print("Shape dispose");
    }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        print("Drawing Circle");
    }

    @Override
    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        print("Drawing Triangle");
    }

    @Override
    void dispose() {
        print("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }

    void dispose() {
        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }

    @Override
    public void dispose() {
        print("CADSystem.dispose()");
        // The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    /**
     * 确保正确清理
     * Java中没有C++中析构函数的概念。
     * <p>
     * 析构函数是一种在对象被销毁时可以被自动调用的函数。
     * <p>
     * 其原因可能是因为在Java中，我们的习惯只是忘掉而不是销毁对象，并且让垃圾回收器在必要时释放其内存。
     * <p>
     * 通常这样做是好事，但有时类可能要在其生命周期内执行一些必需的清理活动。
     * <p>
     * 正如我们在第5章中所提到的那样，
     * 你并不知道垃圾回收器何时将会被调用，或者它是否将被调用。
     * <p>
     * 因此，如果你想要某个类清理一些东西，就必须显式地编写一个特殊方法来做这件事，
     * 并要确保客户端程序员知晓他们必须要调用这一方法。
     * <p>
     * 就像在第12章所描述的那样，其首要任务就是，必须将这一清理动作置于finally子句之中，以预防异常的出现。
     * 请思考一下下面这个能在屏幕上绘制图案的计算机辅助设计系统示例：
     * <p>
     * <p>
     * 此系统中的一切都是某种Shape
     * (Shape自身就是一种Object,因为Shape继承自根类Object)。
     * <p>
     * 每个类都覆写Shape的dispose()方法，并运用super来调用该方法的基类版本。
     * <p>
     * 尽管对象生命期中任何被调用的方法都可以做一些必需的清理工作，
     * <p>
     * 但是Circle、Triangle和Line这些特定的Shape类仍然都带有可以进行"绘制"的构造器。
     * <p>
     * 每个类都有自己的dispose()方法, 将未存于内存之中的东西恢复到对象存在之前的状态
     * <p>
     * 在main()中可以看到try和finally这两个之前还没有看到过的关键字，我们
     * 将在第12章对它们进行详细解释。
     * <p>
     * 关键字try表示，下面的块（用一组大括号括起来的范围）是所谓的保护区(guarded region)，
     * 这意味着它需要被特殊处理。
     * <p>
     * <p>
     * 其中一项特殊处理就是无论try块是怎样退出的，保护区后的finally子句中的代码总是要被执行的。
     * <p>
     * 这里和finally子句表示的是"无论发生什么事，一定要为x调用dispose()
     * <p>
     * 在清理方法(dispose()）中，还必须注意对基类清理方法和成员对象清理
     * <p>
     * <p>
     * <p>
     * 方法的调用顺序，以防某个子对象依赖于另一个子对象情形的发生。
     * <p>
     * 一般而言，所采用的形式应该与C++编译器在其析构函数上所施加的形式相同：
     * 首先，执行类的所有特定的清理动作，其顺序同生成顺序相反
     * （通常这就要求基类元素仍旧存活）；
     * <p>
     * 然后，就如我们所示范的那样，调用基类的清理方法。
     * 许多情况下，清理并不是问题，仅需让垃圾回收器完成该动作就行。
     * <p>
     * 但当必须亲自处理清理时，就得多做努力并多加小心。
     * <p>
     * 因为，一旦涉及垃圾回收，能够信赖的事就不会很多了。
     * <p>
     * 垃圾回收器可能永远也无法被调用，即使被调用，它也可能以任何它想要的顺序来回收对象。
     * <p>
     * 最好的办法是除了内存以外，不能依赖垃圾回收器去做任何事。
     * <p>
     * 如果需要进行清理，最好是编写你自己的清理方法，但不要使用finalize()
     */
    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            // Code and exception handling...
            System.out.println("");
        } finally {
            x.dispose();
        }
    }
}