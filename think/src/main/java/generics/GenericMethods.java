package generics;

public class GenericMethods {
    /**
     * 泛型参数列表 放置 在返回值之前.
     * 使用泛型方法时,通常不必指明参数类型,因为编译器为我们找出具体的类型.
     * 这称为类型参数推断.因此,我们可以像调用普通方法一样调用f()方法.
     * 而且就好像f()被无限次重载过.
     * 它甚至可以接受GenericMethods作为其类型参数.
     * <p>
     * 如果调用f()时传入基本类型,自动打包机制就会介入其中,将基本类型的值
     * 包装成对应的对象.事情上,泛型方法与自动打包避免了许多以前
     * 我们不得不自己编写出来的代码
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.<String>f("");
        gm.<Integer>f(1);
        gm.<Double>f(1.0);
        gm.<Float>f(1.0F);
        gm.<Character>f('c');
        gm.<GenericMethods>f(gm);
    }
}