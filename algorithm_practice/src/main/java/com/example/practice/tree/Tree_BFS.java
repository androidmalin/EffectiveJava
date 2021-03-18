package com.example.practice.tree;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 循环和递归的区别和联系
 * https://blog.csdn.net/Beyond_2016/article/details/81283054
 * <p>
 * 递归（recursion）：在函数内调用自身，将复杂情况逐步转化成基本情况。
 * 循环（loop）：在满足条件的情况下，重复执行同一段代码，比如while语句
 */
public class Tree_BFS {
    public static void main(String[] args) {
        TreeCreateFactory.init(Arrays.asList(1, 2, 3, 4, 5, 6, null));
        TreeNode root = TreeCreateFactory.getRootNode();
        printLine(root);
        System.out.println("levelOrder");
        levelOrder(root);
        System.out.println("traversal");
        bfs_recursion_traversal(root);
    }


    /**
     * 广度优先是一种横向的获取方式，先从树的较浅层开始获取节点，
     * 直接获取完同层次的所有页面后才进入下一层。
     * 层次遍历是广度优先遍历，层次遍历是二叉树按照从根节点到叶子节点的层次关系，
     * 一层一层横向遍历各个节点。
     * <p>
     * 思路
     * 层次遍历的非递归借助了队列实现，队列的特点是先进先出。
     * 首先访问根节点并进队，队列不为空时出队并输出节点的值，
     * 如果当前出队节点有左孩子则左孩子先进队，如果有右孩子则右孩子后进队
     */
    private static void printLine(TreeNode rootNode) {

        //1.声明一个集合存储节点中的值元素
        List<Integer> resultList = new ArrayList<>();

        //2.创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();

        //3.队列中加入根节点
        queue.offer(rootNode);

        //4.开始循环,循环的终止条件是:队列中元素个数为0
        //根据队列的特点,先进先出
        while (!queue.isEmpty()) {

            //5.取出队列中存储的第一个节点名为tempNode
            TreeNode tempNode = queue.poll();

            //6.加入tempNode该节点的左子节点到队列(如果左子节点不为空)
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }

            //7.加入tempNode该节点的右子节点到队列(如果右子节点不为空)
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }

            //8.当前节点的值加入集合中
            resultList.add(tempNode.val);
        }
        System.out.println(resultList);
    }

    /**
     * 广度优先遍历
     * BFS + 非递归写法
     */
    private static List<List<Integer>> levelOrder(TreeNode rootNode) {

        //1.声明一个集合存储节点中的值元素
        List<List<Integer>> dataList = new ArrayList<>();
        if (rootNode == null) return dataList;

        //2.创建一个队列
        Queue<TreeNode> queue = new ArrayDeque<>();

        //3.队列中加入根节点
        queue.offer(rootNode);

        //4.开始循环,循环的终止条件是:队列中元素个数为0
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //5.取出队列中存储的第一个节点名为tempNode
                TreeNode tempNode = queue.poll();
                list.add(tempNode.val);

                //6.加入tempNode该节点的左子节点到队列(如果左子节点不为空)
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                //7.加入tempNode该节点的右子节点到队列(如果右子节点不为空)
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            //8.当前节点的值加入集合中
            dataList.add(list);
        }
        System.out.println(dataList);
        return dataList;
    }


    /**
     * 广度优先遍历
     * BFS + 递归
     */
    private static void bfs_recursion_traversal(TreeNode root) {
        // 每一层都要借助一个 List 存储元素
        List<List<Integer>> resultList = new ArrayList<>();
        find(resultList, 0, root);
        System.out.println("递归");
        System.out.println(resultList);
    }


    /**
     * 将第 level 层的 node 节点放入 res 的第 level 个集合中
     */
    private static void find(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) return;
        if (res.size() <= level) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
        } else {
            List<Integer> list = res.get(level);
            list.add(node.val);
        }
        find(res, level + 1, node.left);
        find(res, level + 1, node.right);
    }
}
