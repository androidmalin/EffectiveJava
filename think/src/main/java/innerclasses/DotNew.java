package innerclasses;
// Creating an inner class directly using the .new syntax.

public class DotNew {
    public class Inner {
    }

    /**
     * 要想直接创建内部类的对象，你不能按照你想象的方式，去引用外部类的名字DotNew,
     * <p>
     * 而是必须使用外部类的对象来创建该内部类对象，就像在上面的程序中所看到的那样。
     * <p>
     * 这也解决了内部类名字作用域的问题，因此你不必声明（实际上你不能声明）dn.new DotNew.Inner()
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner inner = dn.new Inner();
        System.out.println(inner);
    }
}
