package innerclasses;

class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}


/**
 * 当将内部类向上转型为其基类，尤其是转型为一个接囗的时候，内部类就有
 * 了用武之地。
 * <p>
 * （从实现了某个接囗的对象，得到对此接囗的引用，与向上转型为这个对象的基类，实质上效果是一样的。）
 * <p>
 * 这是因为此内部类--某个接囗的实现--能够完全不可见，并且不可用。
 * <p>
 * 所得到的只是指向基类或接囗的引用，所以能够很方便地隐藏实现细节。
 * <p>
 * <p>
 * <p>
 * 于是，private内部类给类的设计者提供了一种途径，
 * 通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。
 * <p>
 * 此外，从客户端程序员的角度来看，由于不能访问任何新增加的、
 * 原本不属于公共接囗的方法，所以扩展接囗是没有价值的。
 * <p>
 * 这也给Java编译器提供了生成更高效代码的机会.
 * <p>
 * 重点关注
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        System.out.println(c.value());

        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());

        // Illegal -- can't access private class:
        //!Parcel4.PContents pc = p.new PContents();
    }
}
