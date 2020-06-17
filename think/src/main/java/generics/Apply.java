package generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

class Shape {
    public void rotate() {
        print(this + " rotate");
    }

    public void resize(int newSize) {
        print(this + " resize " + newSize);
    }
}

class Square extends Shape {
}

/**
 * <p>
 * FilledList表示有点进退两难的情况。为了使某种类型可用，它必须有默认（无参）构造器，
 * 但是Java没有任何方式可以在编译期断言这种事情，因此这就变成了一个运行时问题。
 * <p>
 * 确保编译期检查的常见建议是定义一个工厂接囗，它有一个可以生成对象的方法，
 * 然后FilledList将接受这个接囗而不是这个类型标记的"原生工厂"，
 * 而这样做的问题是在FilledList中使用的所有类都必须实现这个工厂接囗。
 * <p>
 * 唉，大多数的类都是在不了解你的接囗的情况下创建的，因此也就没有实
 * 现这个接囗。稍后，我将展示一种使用适配器的解决方案。
 * <p>
 * 但是上面所展示的使用类型标记的方法可能是一种合理的折中（至少是一种
 * 马上就能想到解决方案）。
 * <p>
 * 通过这种方式，使用像F引edList这样的东西就会非常容易，
 * 我们会马上想到要使用它而不是会忽略它。
 * <p>
 * 当因为错误是在运行时报告的，所以你要有把握，这些错误将在开发过程的早期出现。
 * <p>
 * 注意，类型标记技术是Java文献推荐的技术，例如Gilad Bracha在他的论文
 * 《Generics in Java Programming Language》中写道"这是一种惯用法，
 * 例如，在操作注解的新API中得到了广泛的应用"。
 * https://www.oracle.com/technetwork/java/javase/generics-tutorial-159168.pdf
 *
 * <p>
 * 但是，我发现人们对这种技术的适应程度不一，有些人强烈地首选本章前面描述的工厂方式。
 * 尽管Java解决方案被证明很优雅，但是我们必须知道使用反射（尽管反射在
 * 最近版本的Java中已经明显地改善了）可能比非反射的实现要慢一些，因为有太
 * 多的动作都是在运行时发生的。
 * <p>
 * 这不应该阻止你使用这种解决方案的脚步，至少
 * 可以将其作为一种马上就能想到的解决方案（以防止陷入不成熟的优化中），
 * 但这毫无疑问是这两种方法之间的一个差异。
 * <p>
 * https://www.javaworld.com/article/2076044/generics-and-java.html
 */
class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++) {
                // Assumes default constructor:
                add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


/**
 * 在Apply中，我们运气很好，因为碰巧在Java中内建了一个由Java容器类库使用的Iterable接囗。
 * 正由于此，apply方法可以接受任何实现了Iterable接囗的事物，
 * 包括诸如List这样的所有collection类。
 * <p>
 * 但是它还可以接受其他任何事物，
 * 只要能够使这些事物实现了Iterable接口
 * <p>
 * 在Apply.java中，异常被转换为RuntimeException,因为没有多少办法可以
 * 从这种异常中恢复一在这种情况下，它们实际上代表着程序员的错误。
 * 注意，我必须放置边界和通配符，以便和FilledList在所有需要的情况
 * 下都可以使用。可以试验一下，将这些边界和通配符拿出来，你就会发现某些
 * Apply和FilledList应用将无法工作。
 */
class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S s, Method method, Object... args) {
        for (T t : s) {
            try {
                method.invoke(t, args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 重点关注
 */
class ApplyTest {
    public static void main(String[] args) throws Exception {

        //1.shapes
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);

        //2.squares
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledList<>(Shape.class, 10), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

        //3.shapeQ
        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
