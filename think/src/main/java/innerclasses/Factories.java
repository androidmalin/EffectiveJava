package innerclasses;

import static net.mindview.util.Print.print;

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {
    }

    public void method1() {
        print("Implementation1 method1");
    }

    public void method2() {
        print("Implementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {
    private Implementation2() {
    }

    public void method1() {
        print("Implementation2 method1");
    }

    public void method2() {
        print("Implementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

/**
 * 现在用于Implementation1和Implementation2的构造器都可以是private的，
 * 并且没有任何必要去创建作为工厂的具名类。
 * <p>
 * 另外，你经常只需要单一的工厂对象，因此在本例中它被创建为service实现中的一个static域。
 * <p>
 * 这样所产生语法也更具有实际意义。
 * <p>
 * 重点关注
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        // Implementations are completely interchangeable:
        serviceConsumer(Implementation2.factory);
    }
}