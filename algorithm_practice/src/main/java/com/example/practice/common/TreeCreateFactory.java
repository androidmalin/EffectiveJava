package com.example.practice.common;

import java.util.LinkedList;
import java.util.List;

/**
 * 本地测试环境, 能打印出二叉树的  字符串
 * 给定一个数组, 生成一个TreeNode的数据, 并将这颗树打印出来.
 * https://blog.csdn.net/seagal890/article/details/79732214
 */
public final class TreeCreateFactory {

    public static TreeNode init(Integer... integers) {
        if (integers == null) throw new NullPointerException("root is null");
        if (integers.length > 1 && integers[0] == null)
            throw new NullPointerException("root is null");
        return TreeCreateFactory.createBinTree(integers);
    }

    public static TreeNode createBinTree(Integer[] array_integer) {
        List<TreeNode> nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (Integer num_integer : array_integer) {
            if (num_integer == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(num_integer));
            }
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array_integer.length / 2 - 1; parentIndex++) {
            if (nodeList.get(parentIndex) != null) {
                // 左孩子
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
                // 右孩子
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array_integer.length / 2 - 1;

        if (array_integer.length == 1) {
            //只有一个根节点的情况
            // 左孩子
            if (nodeList.get(0) != null) {
                nodeList.get(0).left = null;
                nodeList.get(0).right = null;
            }
        } else {
            // 左孩子
            if (nodeList.get(lastParentIndex) != null) {
                nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
            }
            // 右孩子,如果数组的长度为奇数才建立右孩子
            if (array_integer.length % 2 == 1) {
                if (nodeList.get(lastParentIndex) != null) {
                    nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
                }
            }
        }
        return nodeList.get(0);
    }
}