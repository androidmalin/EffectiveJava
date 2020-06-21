package innerclasses;

interface A {
}

interface B {
}

class X implements A, B {
}

class Y implements A {
    B makeB() {
        // Anonymous inner class:
        return new B() {
        };
    }
}

public class MultiInterfaces {
    static void takesA(A a) {
    }

    static void takesB(B b) {
    }

    public static void main(String[] args) {
        X x = new X();
        takesA(x);
        takesB(x);

        Y y = new Y();
        takesA(y);
        takesB(y.makeB());
    }
}
