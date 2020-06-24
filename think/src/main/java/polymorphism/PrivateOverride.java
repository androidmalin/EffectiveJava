package polymorphism;

import static net.mindview.util.Print.print;

public class PrivateOverride {
    private void f() {
        print("private f()");
    }


    /**
     * 我们所期望的输出是public f()，但是由于private方法被自动认为是final方法,
     * 而且对导出类是屏蔽的。
     * <p>
     * 因此，在这种情况下，Derived类中的f()方法就是一个全新的方法；
     * 既然基类中的f()方法在子类Derived中不可见，因此甚至也不能被重载。
     * <p>
     * 结论就是：只有非private方法才可以被覆盖；但是还需要密切注意覆盖
     * private方法的现象，这时虽然编译器不会报错，但是也不会按照我们所期望的来执行。
     * <p>
     * 确切地说，在导出类中，对于基类中的private方法，最好采用不同的名子。
     */
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}


class Derived extends PrivateOverride {
    private void f() {
        print("public f()");
    }
}
