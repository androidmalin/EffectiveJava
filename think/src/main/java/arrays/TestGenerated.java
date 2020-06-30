package arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

public class TestGenerated {

    /**
     * 即使数组a被初始化过，其中的那些值也在将其传递给Generated.array()
     * 之后被覆写了，因为这个方法会替换这些值（但是会保证原数组的正确性）。
     * <p>
     * b的初始化展示了如何从无到有地创建填充了元素的数组。
     * <p>
     * 泛型不能用于基本类型，而我们确实想用生成器来填充基本类型数组。
     * <p>
     * 为了解决这个问题，我们创建了一个转换器，它可以接收任意的包装器对象数组，
     * 并将其转换为相应的基本类型数组。
     * <p>
     * 如果没有这个工具，我们就必须为所有的基本类型创建特殊的生成器。
     */
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));

        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }
}