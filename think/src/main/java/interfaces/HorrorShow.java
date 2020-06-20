package interfaces;


interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

// Extending an interface with inheritance.
class DragonZilla implements DangerousMonster {
    public void menace() {
    }

    public void destroy() {
    }
}

interface Vampire extends DangerousMonster, Lethal {
    @SuppressWarnings("unused")
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void kill() {
    }

    @Override
    public void drinkBlood() {
    }
}


/**
 * 通过继承来扩展接囗
 * 通过继承，可以很容易地在接囗中添加新的方法声明，还可以通过继承在新接囗中组合数个接囗。
 * <p>
 * 这两种情况都可以获得新的接囗，就像在下例中所看到
 * <p>
 * <p>
 * DangerousMonster是Monster的直接扩展，它产生了一个新接囗。
 * DragonZilla中实现了这个接囗。
 * <p>
 * 在Vampire中使用的语法仅适用于接囗继承。
 * 一般情况下，只可以将extends用于单一类，但是可以引用多个基类接囗。
 * <p>
 * 就像所看到的，只需用逗号将接囗名一一分隔开即可。
 */
public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
