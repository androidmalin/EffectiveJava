package com.example.practice.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 本地测试环境, 能打印出二叉树的  字符串
 * 给定一个数组, 生成一个TreeNode的数据, 并将这颗树打印出来.
 * https://blog.csdn.net/seagal890/article/details/79732214
 */
public final class TreeCreateFactory {

    public static List<TreeNode> nodeList = null;

    public static TreeNode getRootNode() {
        return nodeList.get(0);
    }

    public static void createBinTree(Integer[] ARRAY_DATA) {
        nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (Integer arrayDatum : ARRAY_DATA) {
            if (arrayDatum == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(arrayDatum));
            }
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < ARRAY_DATA.length / 2 - 1; parentIndex++) {
            if (nodeList.get(parentIndex) != null) {
                // 左孩子
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
                // 右孩子
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = ARRAY_DATA.length / 2 - 1;
        // 左孩子
        if (nodeList.get(lastParentIndex) != null) {
            nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        }
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (ARRAY_DATA.length % 2 == 1) {
            if (nodeList.get(lastParentIndex) != null) {
                nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
            }
        }
    }

    /**
     * 问题描述:根据二叉树的一个根节点,对它进行层次遍历;
     * 解决方法:非递归+BFS
     * 归类:二叉树的层次遍历
     * <p>
     * 参考链接:
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //1.使用队列的特性,先进先出.
        Queue<TreeNode> queue = new LinkedList<>();
        //2.将根节点加入队列中.
        queue.offer(root);
        int levelNum = 1;
        //3.开始循环
        while (!queue.isEmpty()) {
            System.out.println("第" + levelNum + "层节点为" + queue);
            ArrayList<Integer> levelNodeList = new ArrayList<>();
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时levelList中
            //如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodeList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelNodeList);
            levelNum++;
        }
        System.out.println(result);
        return result;
    }

    /**
     * 使用方法  TreeCreateFactory.init(Arrays.asList(1, 2, 3, 4, 5, 6, null));
     */
    public static void init(List<Integer> list) {
        Integer[] array = (Integer[]) list.toArray();
        TreeCreateFactory.createBinTree(array);
        TreeNode rootNode = TreeCreateFactory.nodeList.get(0);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-----------------开始-------------------");
        System.out.println("二叉树如下所示:");
        TreeOperation.show(getRootNode());
        System.out.println("\n");
        System.out.println("二叉树的层次遍历为:");
        levelOrder(rootNode);
        System.out.println("-----------------结束-------------------");
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        TreeCreateFactory.init(Arrays.asList(1, 2, 3, 4, 5, 6, null));
    }
}