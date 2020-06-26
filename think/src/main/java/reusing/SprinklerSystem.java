package reusing;

// Composition for code reuse.
// 组合为了代码的复用
class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

//SprinklerSystem:洒水器系统
public class SprinklerSystem {
    private String valve1;
    private String valve2;
    private String valve3;
    private String valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return
                "valve1 = " + valve1 + " " +
                        "valve2 = " + valve2 + " " +
                        "valve3 = " + valve3 + " " +
                        "valve4 = " + valve4 + "\n" +
                        "i = " + i + " " + "f = " + f + " " +
                        "source = " + source;
    }


    /**
     * 在上面两个类所定义的方法中，有一个很特殊：toString()。
     * 每一个非基本类型的对象都有一个toString()方法，而且当编译器需要一个String而你却只有
     * 一个对象时，该方法便会被调用。
     * 所以在SprinklerSystem.toString()的表达式
     * 中：
     * <p>
     * "source=" +source.
     * <p>
     * 编译器将会得知你想要将一个String对象（"source="）同WaterSource相加。
     * <p>
     * 由于只能将一个String对象和另一个String对象相加，因此编译器会告诉你：
     * "我将调用toString()，把source转换成为一个String！"
     * <p>
     * 这样做之后，它就能够将两个String连接到一起并将结果传递给System.out.println()
     * <p>
     * 每当想要使所创建的类具备这样的行为时，仅需要编写一个toString()方法即可。
     */
    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}
