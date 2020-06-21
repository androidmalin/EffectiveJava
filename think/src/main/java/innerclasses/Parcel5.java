package innerclasses;

/**
 * Nesting a class within a method.
 * 在方法中嵌套一个类。
 * 在方法的作用域内创建一个完整的类,这被称为局部内部类
 */
public class Parcel5 {

    public Destination destination(String s) {

        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }
}
