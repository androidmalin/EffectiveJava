package generics;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    private Class<T> kind;


    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    /**
     * 如上看到的，但凡是涉及到确切类型信息的操作，
     * 在泛型内部都是无法共工作的。
     * 那是否有办法绕过这个问题来编程，答案就是显示地传递 类型标签。
     * https://segmentfault.com/a/1190000003831229
     * https://www.jianshu.com/p/4806217a2d0c
     */
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}