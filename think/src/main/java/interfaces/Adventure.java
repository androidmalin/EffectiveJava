package interfaces;


interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}


/**
 * 接囗不仅仅只是一种更纯粹形式的抽象类，它的目标比这要高。
 * <p>
 * 因为接囗是根本没有任何具体实现的一也就是说，没有任何与接囗相关的存储；
 * <p>
 * 因此，也就无法阻止多个接囗的组合。
 * <p>
 * 这一点是很有价值的，因为你有时需要去表示"一个x是一个a和一个b以及一个c"。
 * <p>
 * 在c++中，组合多个类的接囗的行为被称作多重继承。
 * 它可能会使你背负很沉重的包袱，因为每个类都有一个具体实现。
 * 在Java中，你可以执行相同的行为，但是只有一个类可以有具体实现；
 * 因此，通过组合多个接囗，c++中的问题是不会在Java中发生的：
 * <p>
 * 在导出类中，不强制要求必须有一个是抽象的或"具体的"（没有任何抽象方
 * 法的）基类。
 * <p>
 * 如果要从一个非接囗的类继承，那么只能从一个类去继承。
 * 其余的基元素都必须是接囗。
 * 需要将所有的接囗名都置于implements关键字之后，用逗号将它们一一隔开。
 * 可以继承任意多个接囗，并可以向上转型为每个接囗，因为每一个接囗都是一个独立类型。
 * <p>
 * 下面的例子展示了一个具体类组合数个接囗之后产生了一个新类：
 * <p>
 * <p>
 * 可以看到，Hero组合了具体类ActionCharacter和接CanFight、CanSwim
 * 和CanFly当通过这种方式将一个具体类和多个接囗组合到一起时，这个具体类
 * 必须放在前面，后面跟着的才是接囗（否则编译器会报错）。
 * <p>
 * 注意，CanFight接囗与ActionCharacter类中的fight()方法的特征签名是
 * 一样的，而且，在Hero中并没有提供和fight()的定义。
 * <p>
 * 可以扩展接囗，但是得到的只是另一个接囗。
 * 当想要创建对象时，所有的定义首先必须都存在。
 * 即没有显式地提供和fight的定义，其定义也因ActionCharacter而随之而来，
 * 这样就使得创建Hero对象成为了可能。
 * <p>
 * <p>
 * 在Adventure类中，可以看到有四个方法把上述各种接囗和具体类作为参数。
 * 当Hero对象被创建时，它可以被传递给这些方法中的任何一个，这意味着它依次
 * 被向上转型为每一个接囗。由于Java中这种设计接囗的方式，使得这项工作并不
 * 需要程序员付出任何特别的努力。
 * <p>
 * 一定要记住，前面的例子所展示的就是使用接囗的核心原因：为了能够向上
 * 转型为多个基类型（以及由此而带来的灵活性）。
 * <p>
 * 然而，使用接囗的第二个原因却是与使用抽象基类相同：防止客户端程序员创建该类的对象，
 * 并确保这仅仅是建立一个接囗。
 * <p>
 * 这就带来了一个问题：我们应该使用接囗还是抽象类？
 * 如果要创建不带任何方法定义和成员变量的基类，那么就应该选择接囗而不是抽象类。
 * <p>
 * 事实上，如果知道某事物应该成为一个基类，那么第一选择应该是使它成为一个接
 * 囗（该主题在本章的总结中将再次讨论）
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {
    }

    @Override
    public void fly() {
    }
}


public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h); // Treat it as an ActionCharacter
    }
}
