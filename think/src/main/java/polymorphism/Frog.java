package polymorphism;

import static net.mindview.util.Print.print;


/**
 * 特征
 */
class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        print("Creating Characteristic " + s);
    }

    /**
     * 处置
     */
    protected void dispose() {
        print("disposing Characteristic " + s);
    }
}

/**
 * 描述
 */
class Description {
    private String s;

    Description(String s) {
        this.s = s;
        print("Creating Description " + s);
    }

    protected void dispose() {
        print("disposing Description " + s);
    }
}

/**
 * 生物
 */
class LivingCreature {

    private Characteristic p = new Characteristic("is alive");

    private Description t = new Description("Basic Living Creature");

    LivingCreature() {
        print("LivingCreature()");
    }

    protected void dispose() {
        print("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {

    private Characteristic p = new Characteristic("has heart");

    private Description t = new Description("Animal not Vegetable");

    Animal() {
        print("Animal()");
    }

    @Override
    protected void dispose() {
        print("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

/**
 * 两栖动物
 */
class Amphibian extends Animal {

    private Characteristic p = new Characteristic("can live in water");
    private Description t = new Description("Both water and land");

    Amphibian() {
        print("Amphibian()");
    }

    @Override
    protected void dispose() {
        print("Amphibian dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}


/**
 * 青蛙
 */
public class Frog extends Amphibian {

    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats Bugs");

    public Frog() {
        print("Frog()");
    }

    @Override
    protected void dispose() {
        print("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    /**
     * 通过组合和继承方法来创建新类时，永远不必担心对象的清理问题，
     * 子对象通常都会留给垃圾回收器进行处理。
     * <p>
     * 如果确实遇到清理的问题，那么必须用心为新类创建dispose()方法（在这里我选用此名称；读者可以提出更好的）。
     * <p>
     * 并且由于继承的缘故，如果我们有其他作为垃圾回收一部分的特殊清理动作，就必须
     * 在导出类中覆盖dispose()方法。
     * <p>
     * 当覆盖被继承类的dispose()方法时，务必记住调用基类版本dispose()方法；
     * <p>
     * 否则，基类的清理动作就不会发生。
     * <p>
     * 下例就证明了这一点：
     * <p>
     * 层次结构中的每个类都包含Characteristic和Description两种类型的成员对象，并且它们也必须被销毁。
     * <p>
     * 所以万一某个子对象要依赖于其他对象，销毁的顺序应该和初始化顺序相反。
     * <p>
     * 对于字段，则意味着与声明的顺序相反（因为字段的初始化是按照声明的顺序进行的）。
     * <p>
     * 对于基类（遵循c++中析构函数的形式）应该首先对其导出类进行清理，然后才是基类。
     * <p>
     * 这是因为导出类的清理可能会调用基类中的某些方法，
     * 所以需要使基类中的构件仍起作用而不应过早地销毁它们。
     * <p>
     * 从输出结果可以看到，Frog对象的所有部分都是按照创建的逆序进行销毁
     * 在这个例子中可以看到，尽管通常不必执行清理工作，但是一旦选择要执
     * 行，就必须谨慎和小心。
     * <p>
     * <p>
     * 在上面的示例中还应该注意到，Frog对象拥有其自己的成员对象。
     * <p>
     * Frog对象创建了它自己的成员对象，并且知道它们应该存活多久（只要Frog存活着），因
     * 此Frog对象知道何时调用dispose()去释放其成员对象。
     * <p>
     * 然而，如果这些成员对象中存在于其他一个或多个对象共享的情况，问题就变得更加复杂了，
     * 你就不能简单地假设你可以调用dispose()了。
     * <p>
     * 在这种情况下，也许就必需使用引用计数来跟踪仍旧访问着共享对象的对象数量了。
     */
    public static void main(String[] args) {
        Frog frog = new Frog();
        print("Bye!");
        frog.dispose();
    }
}