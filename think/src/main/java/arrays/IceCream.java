package arrays;

import java.util.Arrays;
import java.util.Random;

// Returning arrays from methods.
public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8"
    };

    /**
     * do {
     * //代码语句
     * }while(布尔表达式);
     * 注意：布尔表达式在循环体的后面，所以语句块在检测布尔表达式之前已经执行了。
     * 如果布尔表达式的值为 true，则语句块一直执行，直到布尔表达式的值为 false。
     */
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }

        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}