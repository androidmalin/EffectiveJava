package arrays;

import java.util.Arrays;

import static net.mindview.util.Print.print;

// Using System.arraycopy()
public class CopyingArrays {

    /**
     * arraycopy()需要的参数有：
     * 源数组，
     * 表示从源数组中的什么位置开始复制的偏移量，
     * 表示从目标数组的什么位置开始复制的偏移量，
     * 以及需要复制的元素个数。
     * <p>
     * 当对数组的任何越界操作都会导致异常。
     * <p>
     * 这个例子说明基本类型数组与对象数组都可以复制。
     * <p>
     * 然而，如果复制对象数组，那么只是复制了对象的引用一而不是对象本身的拷贝。
     * <p>
     * 这被称作浅复制(shallow copy)（参见本书的在线补充材料以了解更多的内容）
     * <p>
     * System．arraycopy()不会执行自动包装和自动拆包，两个数组必须具有相同的确切类型。
     */
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        print("i = " + Arrays.toString(i));
        print("j = " + Arrays.toString(j));

        System.arraycopy(i, 0, j, 0, i.length);
        print("j = " + Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        print("k = " + Arrays.toString(k));

        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        print("i = " + Arrays.toString(i));

        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, 47);
        Arrays.fill(v, 99);
        print("u = " + Arrays.toString(u));
        print("v = " + Arrays.toString(v));

        System.arraycopy(v, 0, u, u.length / 2, v.length);
        print("u = " + Arrays.toString(u));
    }
}