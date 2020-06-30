package arrays;

import java.util.Arrays;

public class AutoboxingArrays {

    /**
     * 重点关注
     */
    public static void main(String[] args) {
        Integer[][] a = { // Autoboxing:
                {1, 2,},

                {3, 4,},

                {5, 6,},

                {7, 8,},
        };
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
        System.out.println(Arrays.toString(a[3]));

        //打印出二维数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("a[" + i + "]" + "[" + j + "]:" + a[i][j] + "      ");
            }
            //输出一列后就回车空格
            System.out.println();
        }
    }
}
