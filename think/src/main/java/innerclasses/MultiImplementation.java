package innerclasses;

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

/**
 * 如果不需要解决"多重继承"的问题，那么自然可以用别的方式编码，而不需
 * 要使用内部类。
 * 但如果使用内部类，还可以获得其他一些特性：
 * <p>
 * 1）内部类可以有多个实例，每个实例都有自己的状态信息，并且与其外围类对象的信息相互独立。
 * <p>
 * 2）在单个外围类中，可以让多个内部类以不同的方式实现同一个接囗，或继承同一个类。稍后就会展示一个这样的例子。
 * <p>
 * 3）创建内部类对象的时刻并不依赖于外围类对象的创建。
 * <p>
 * 4）内部类并没有令人迷惑的"is一a"关系；它就是一个独立的实体。
 */
public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}