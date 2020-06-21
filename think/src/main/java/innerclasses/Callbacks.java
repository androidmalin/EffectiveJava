package innerclasses;

import static net.mindview.util.Print.print;

interface Incrementable {
    void increment();
}

// Very simple to just implement the interface:
class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    public void increment() {
        print("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        print(i);
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            // Specify outer-class method, otherwise you'd get an infinite recursion:
            // 指定外部类方法，否则将获得无限递归：
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    void go() {
        callbackReference.increment();
    }
}


/**
 * 闭包(closure)是一个可调用的对象，它记录了一些信息，这些信息来自于
 * 创建它的作用域。
 * <p>
 * 通过这个定义，可以看出内部类是面向对象的闭包，
 * 因为它不仅包含外围类对象（创建内部类的作用域）的信息，
 * <p>
 * 还自动拥有一个指向此外围类对象的引用，在此作用域内，内部类有权操作所有的成员，包括private成员。
 * Java最引人争议的问题之一就是，人们认为Java应该包含某种类似指针的机制，以允许回调(callback)。
 * <p>
 * 通过回调，对象能够携带一些信息，这些信息允许它在稍后的某个时刻调用初始的对象。
 * <p>
 * 稍后将会看到这是一个非常有用的概念
 * 如果回调是通过指针实现的，那么就只能寄希望于程序员不会误用该指针。
 * 然而，读者应该已经了解到，Java更小心仔细，所以没有在语言中包括指针。
 * <p>
 * 通过内部类提供闭包的功能是优良的解决方案，它比指针更灵活、更安全。
 * 见下例：
 * <p>
 * <p>
 * 这个例子进一步展示了外围类实现一个接囗与内部类实现此接囗之间的区别。
 * <p>
 * 就代码而言，Callee1是简单的解决方式。Callee2继承自MyIncrement,
 * 后者已经有了一个不同的increment()方法，并且与Incrementable接囗期望的
 * increment()方法完全不相关。
 * <p>
 * 所以如果Callee2继承了MyIncrement,就不能为了Incrementable的用途而覆盖increment()方法，
 * 于是只能使用内部类独立地实现Incrementable.
 * 还要注意，当创建了一个内部类时，并没有在外围类的接囗中添加东西，也没有修改外围类的接囗。
 * <p>
 * 注意，在Callee2中除了getCallbackReference()以外，其他成员都是private的。
 * <p>
 * 要想建立与外部世界的任何连接，interfaceIncrementable都是必需的。
 * 在这里可以看到，interface是如何允许接囗与接囗的实现完全独立的。
 * <p>
 * 内部类Closure实现了Incrementable,以提供一个返回Callee2的"钩子"
 * (hook)--而且是一个安全的钩子。
 * <p>
 * 无论谁获得此Incrementable的引用，都只能调用increment()，除此之外没有其他功能
 * （不像指针那样，允许你做很多事情).
 * <p>
 * Caller的构造器需要一个Incrementable的引用作为参数（虽然可以在任意时刻捕获回调引用），
 * 然后在以后的某个时刻，caller对象可以使用此引用回调Callee类。
 * <p>
 * 回调的价值在于它的灵活性--可以在运行时动态地决定需要调用什么方法。
 * <p>
 * 这样做的好处在第22章可以看得更明显，在那里实现GUI功能的时候，到处都用到了回调。
 * <p>
 * 重点关注
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Caller caller1 = new Caller(c1);
        caller1.go();

        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller2.go();
    }
}