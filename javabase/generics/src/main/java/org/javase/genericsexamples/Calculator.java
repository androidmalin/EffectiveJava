package org.javase.genericsexamples;

/**
 * 泛型方法
 *
 * @author Juneau
 */
public class Calculator {

    /**
     * Example of a non-generic add method, which works only with Integer types.
     */
    public static Integer addInteger(Integer a, Integer b) {
        return a + b;
    }

    /**
     * Example of non-generic add method, which works only with Float types.
     */
    public static Float addFloat(Float a, Float b) {
        return a + b;
    }

    /**
     * Generic method that accepts two GenericContainer objects, and adds their
     * values together, returning the result in double format
     * <p>
     * 有时，我们可能不知道传入方法的参数类型。在方法级别应用泛型可以解决此类问题。
     * 方法参数可以包含泛型类型，方法也可以包含泛型返回类型。
     * <p>
     * 假设我们要开发一个接受 Number 类型的计算器类。
     * 泛型可用于确保可将任何 Number 类型作为参数传递给此类的计算方法。
     * 如下 add() 方法演示了如何使用泛型限制两个参数的类型，确保其包含 Number 的上限：
     * <p>
     * 通过将类型限制为 Number，你可以将 Number 子类的任何对象作为参数传递。
     * 此外，通过将类型限制为 Number，我们还可以确保传递给该方法的任何参数将包含 doubleValue() 方法。
     * 要查看实际效果，如果您想添加一个 Integer 和一个 Float，可以按如下所示调用该方法：
     * <p>
     * double genericValue1 = Calculator.add(3, 3f);
     */
    public static <N extends Number> double add(N a, N b) {
        double sum;
        sum = a.doubleValue() + b.doubleValue();
        return sum;
    }

    public static <S extends Number> int add(S a, S b, S c) {
        int sum;
        sum = a.intValue() + b.intValue() + c.intValue();
        return sum;
    }

}
