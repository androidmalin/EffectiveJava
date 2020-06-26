package reusing;

// Composition with public objects.
class Engine {
    public void start() {
    }

    public void rev() {
    }

    public void stop() {
    }
}

class Wheel {
    public void inflate(int psi) {
    }
}

class Window {
    public void rollup() {
    }

    public void rollDown() {
    }
}

class Door {
    public Window window = new Window();

    public void open() {
    }

    public void close() {
    }
}

public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door();
    public Door right = new Door(); // 2-door

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel();
        }
    }

    /**
     * 7.5 在组合与继承之间选择
     * <p>
     * 组合和继承都允许在新的类中放置子对象，组合是显式地这样做，而继承则是隐式地做。
     * <p>
     * 读者或许想知道二者间的区别何在，以及怎样在二者之间做出选择。
     * <p>
     * 组合技术通常用于想在新类中使用现有类的功能而非它的接囗这种情形。
     * <p>
     * 即，在新类中嵌入某个对象，让其实现所需要的功能，但新类的用户看到的只是
     * 为新类所定义的接囗，而非所嵌入对象的接囗。
     * <p>
     * 为取得此效果，需要在新类中嵌入一个现有类的private对象。
     * <p>
     * 有时，允许类的用户直接访问新类中的组合成分是极具意义的；
     * 也就是说，将成员对象声明为public。
     * <p>
     * 如果成员对象自身都隐藏了具体实现，那么这种做法是安全的。
     * <p>
     * 当用户能够了解到你正在组装一组部件时，会使得端囗更加易于理解。
     * car对象即为一个很好的例子：
     * <p>
     * <p>
     * 由于在这个例子中car的组合也是问题分析的一部分（而不仅仅是底层设计的
     * 部分），所以使成员成为pub将有助于客户端程序员了解怎样去使用类，而且
     * 也降低了类开发者所面临的代码复杂度。
     * <p>
     * 但务必要记得这仅仅是一个特例，一般情况下应该使域成为private
     * <p>
     * 在继承的时候，使用某个现有类，并开发一个它的特殊版本。
     * <p>
     * 通常，这意味着你在使用一个通用类，并为了某种特殊需要而将其特殊化。
     * <p>
     * 略微思考一下就会发现，用一个"交通工具"对象来构成一部"车子"是毫无意义的，
     * 因为"车子"并不包含"交通工具"，它仅是一种交通工具(is-a关系）。
     * <p>
     * "is-a"（是一个）的关系是用继承来表达的，而"has-a"（有一个）的关系则是用组合来表达的。
     */
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
    }
}
