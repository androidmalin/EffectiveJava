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
     * <p>
     * 在泛型方法中,可以显式地指明类型,不过这种语法很少使用.
     * 要显式地指明类型, 必须在点操作符 与 方法名之间插入尖括号,
     * 然后把类型置于尖括号内.
     * <p>
     * 如果是在定义该方法的类的内部,必须在点操作符之前使用this关键字.
     * 如果是使用static的方法,必须在点操作符之前加上类名
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static <T> void f2(T t) {
        System.out.println("xx");
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.<String>f("");
        gm.<Integer>f(1);
        gm.<Double>f(1.0);
        gm.<Float>f(1.0F);
        gm.<Character>f('c');
        gm.<GenericMethods>f(gm);
        GenericMethods.f2("xxx");
    }
}