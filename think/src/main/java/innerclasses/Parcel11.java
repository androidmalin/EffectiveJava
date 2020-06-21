package innerclasses;

// Nested classes (static inner classes).
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        // Nested classes can contain other static elements:
        public static void f() {
        }

        static int x = 10;

        static class AnotherLevel {

            static int x = 10;

            public static void f() {
            }
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }


    /**
     * 如果不需要内部类对象与其外围类对象之间有联系，
     * 那么可以将内部类声明为static这通常称为嵌套类。
     * <p>
     * 想要理解static应用于内部类时的含义，就必须记住，
     * 普通的内部类对象隐式地保存了一个引用，指向创建它的外围类对象。
     * 然而，当内部类是static的时，就不是这样了。
     * <p>
     * 嵌套类意味着：
     * 1）要创建嵌套类的对象，并不需要其外围类的对象。
     * 2）不能从嵌套类的对象中访问非静态的外围类对象。
     * <p>
     * 嵌套类与普通的内部类还有一个区别。
     * 普通内部类的字段与方法，只能放在类的外部层次上，
     * 所以普通的内部类不能有static数据和static字段，也不能包含嵌套类。
     * 但是嵌套类可以包含所有这些东西：
     */
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
        System.out.println(c.value());
        System.out.println(d.readLabel());
    }
}
