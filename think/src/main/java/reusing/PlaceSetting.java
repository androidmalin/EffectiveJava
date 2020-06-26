package reusing;

import static net.mindview.util.Print.print;

// Combining composition & inheritance.
class Plate {
    //盘子
    Plate(int i) {
        print("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    //餐盘
    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor");
    }
}

//餐具
class Utensil {
    Utensil(int i) {
        print("Utensil constructor");
    }
}

//汤匙
class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        print("Spoon constructor");
    }
}

//叉子
class Fork extends Utensil {
    Fork(int i) {
        super(i);
        print("Fork constructor");
    }
}

//刀
class Knife extends Utensil {
    Knife(int i) {
        super(i);
        print("Knife constructor");
    }
}

// A cultural way of doing something:
class Custom {
    Custom(int i) {
        //print("Custom constructor");
    }
}

public class PlaceSetting extends Custom {
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    PlaceSetting(int i) {
        super(i);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        print("PlaceSetting constructor");
    }

    /**
     * 结合使用组合和继承
     * <p>
     * 同时使用组合和继承是很常见的事。
     * 下例就展示了同时使用这两种技术，并配以必要的构造器初始化，来创建更加复杂的类：
     * <p>
     * 虽然编译器强制你去初始化基类，并且要求你要在构造器起始处就要这么做，
     * 但是它并不监督你必须将成员对象也初始化，因此在这一点上你自己必须时刻注意
     * <p>
     * 这些类如此清晰地分离着实使人惊讶。
     * <p>
     * 甚至不需要这些方法的源代码就可以复用这些代码，我们至多只需要导入一个包。
     * （对于继承与组合来说都是如此。）
     */
    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
