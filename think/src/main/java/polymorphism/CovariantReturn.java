package polymorphism;


//Grain:粮食
class Grain {
    public String toString() {
        return "Grain";
    }
}

//Wheat:小麦
class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

//Mill:磨机
class Mill {
    //Grain:粮食
    Grain process() {
        return new Grain();
    }
}

//WheatMill:小麦磨机
class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}

/**
 * 子类复写了父类的某个方法后.子类中该方法的返回值的类型, 可以是该父类方法返回类型的子类.
 * <p>
 * 协变返回类型
 * JavaSE5中添加了协变返回类型，它表示在导出类中的被覆盖方法可以返回
 * 基类方法的返回类型的某种导出类型：
 * <p>
 * <p>
 * <p>
 * JavaSE5与Java较早版本之间的主要差异就是
 * 较早的版本将强制process()的覆盖版本必须返回Grain，而不能返回Wheat,
 * <p>
 * 尽管Wheat是从Grain导出的，因而也应该是一种合法的返回类型。
 * <p>
 * 协变返回类型允许返回更具体的Wheat类型。
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}
