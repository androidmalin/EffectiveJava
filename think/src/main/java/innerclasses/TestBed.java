package innerclasses;


/**
 * 不能运行.
 * 在jdk1.5也是.书上错了
 */
public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
