package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.third_颜色标记法2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(2, 1, 3);
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
        mapTest();
    }

    //单键值对类AbstractMap.SimpleEntry使用方法
    public static void mapTest() {
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("name", "jake");
        System.out.println("new AbstractMap.SimpleEntry: " + entry);
        System.out.println("getKey: " + entry.getKey());
        System.out.println("getValue: " + entry.getValue());
        entry.setValue("jake2");
        System.out.println("setValue: " + entry);
        System.out.println("getValue: " + entry.getValue());
        System.out.println(entry);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        Assertions.assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal(root));
    }
}
