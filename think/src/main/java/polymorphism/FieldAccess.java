package polymorphism;

// Direct field access is determined at compile time.
class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

/**
 * 当Sub对象转型为Super引用时，任何域访问操作都将由编译器解析，因此不是多态的。
 * <p>
 * 在本例中，为Super.filed和Sub.filed分配了不同的存储空间。
 * <p>
 * 这样，Sub实际上包含两个称为filed的域：它自己的和它从Super处得到的。
 * <p>
 * 然而，在引用Sub中的filed时所产生的默认域并非Super版本的filed域。
 * <p>
 * 因此，为了得到Super.field,必须显式地指明super.filed
 * <p>
 * 尽管这看起来好像会成为一个容易令人混淆的问题，但是在实践中，它实际上从来不会发生。
 * <p>
 * 首先，你通常会将所有的域都设置成private，因此不能直接访问它们，其副作用是只能调用方法来访问。
 * <p>
 * 另外，你可能不会对基类中的域和导
 * 出类中的域赋予相同的名字，因为这种做法容易令人混淆。
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // UpCast
        System.out.println(
                "sup.field = " + sup.field
                        + ", sup.getField() = " + sup.getField()
        );

        Sub sub = new Sub();
        System.out.println(
                "sub.field = " + sub.field +
                        ", sub.getField() = " + sub.getField() +
                        ", sub.getSuperField() = " + sub.getSuperField()
        );
    }
}