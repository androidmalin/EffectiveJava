package org.javase.genericsexamples;

/**
 * Using a generic map implementation
 *
 * @author Juneau
 */
public class MultiGenericContainerExample {
    public static void main(String[] args) {
        MultiGenericContainer<String, String> mondayWeather = new MultiGenericContainer<>("Monday", "Sunny");
        String mondayForecast = mondayWeather.getFirstPosition();
        String secondPosition = mondayWeather.getSecondPosition();

        System.out.println("firstPosition:" + mondayForecast);
        System.out.println("secondPosition:" + secondPosition);

        MultiGenericContainer<String, String> mm = new MultiGenericContainer<>();
        System.out.println("firstPosition:" + mm.getFirstPosition());
        System.out.println("secondPosition:" + mm.getSecondPosition());


        // 注：无法将原始类型用于泛型；只能使用引用类型。自动装箱和拆箱操作能够在使用泛型对象时将值存储为原始类型并检索原始类型的值
        // 类型引用可以在分配 getFirstPosition() 或 getSecondPosition() 调用结果时避免显式类型转换。
        // 根据 Oracle 文档，类型引用是 Java 编译器的一项功能，可查看每种方法调用和对应的声明，从而确定支持调用的类型参数。
        // 换言之，编译器根据对象实例化过程中分配的类型确定可以使用的类型，在本例中，为 <String, String> 和 <Integer, Double>。
        // 引用算法尝试找到适用于所有参数的最特定的类型。

        // 看看 MultiGenericContainer 的实例化，也可以使用类型引用避免重复类型声明。
        // 不必指定对象类型两次，只要编译器可以从上下文推断类型，即可以指定尖括号运算符 <>。
        // 因此，可以在实例化对象时使用尖括号运算符

        //通过构造函数存储值时，使用自动装箱 操作将原始类型的 double 值存储为 Double 引用类型
        MultiGenericContainer<Integer, Double> dayOfWeekDegrees = new MultiGenericContainer<>(1, 78.0d);
        // The following would result in an incompatible types error
        //int mondayOutlook = mondayWeather.getSecondPosition();


        // 被称为目标类型化 的概念允许编译器推断泛型调用的类型参数。
        // 目标类型是编译器希望的数据类型，具体取决于用于实例化泛型对象的类型、表达式出现的位置等因素。
        // 在下面的代码行中，值的目标类型是 Double，因为 getSecondPosition() 方法返回 S 类型的值，其中 S 在本例中为 Double。
        // 如前所述，由于拆箱操作，我们能够将调用的值分配给 double 类型的基元。
        // double sundayDegrees = dayOfWeekDegrees.getSecondPosition();

        //借助将引用类型自动转换为原始类型的拆箱 操作
        double sundayDegrees = dayOfWeekDegrees.getSecondPosition();
        System.out.println("sundayDegrees:" + sundayDegrees);

        // Change the Monday outlook to cloudy
        mondayWeather.setSecondPosition("Cloudy");
        // Attempt to accidentally pass the temperature to the mondayWeather instance
        // as the secondPosition will result in a compiler error
        // mondayWeather.setSecondPosition(80.0);


    }
}
