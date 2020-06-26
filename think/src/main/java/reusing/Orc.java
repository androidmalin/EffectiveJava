package reusing;

import static net.mindview.util.Print.print;

// The protected keyword.
class Villain {
    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name); // Available because it's protected
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    /**
     * 7.6 protected关键字
     * 现在，我们已介绍完了继承，关键字protected最终具有了意义。
     * <p>
     * 在理想世界中，仅靠关键字private就已经足够了。
     * <p>
     * 但在实际项目中，经常会想要将某些事物尽可能对这个世界隐藏起来，但仍然允许导出类的成员访问它们。
     * <p>
     * <p>
     * 关键字protected就是起这个作用的。
     * <p>
     * 它指明"就类用户而言，这是private的，但对于任何继承于此类的导出类或其他任何位于同一个包内的类来说，
     * 它却是可以访问的。（protected也提供了包内访问权限。）
     * <p>
     * 尽管可以创建protected域，但是最好的方式还是将域保持为private；
     * <p>
     * 你应当一直保留"更改底层实现"的权利。
     * <p>
     * 然后通过protected方法来控制类的继承者的访问权限。
     */
    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        print(orc);

        orc.change("Bob", 19);
        print(orc);
    }
}