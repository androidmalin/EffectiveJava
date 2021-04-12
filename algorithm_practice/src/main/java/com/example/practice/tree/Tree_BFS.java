package com.example.practice.tree;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 / 广度优先遍历 BFS
 * <p>
 * 循环和递归的区别和联系
 * https://blog.csdn.net/Beyond_2016/article/details/81283054
 * <p>
 * 递归（recursion）：在函数内调用自身,将复杂情况逐步转化成基本情况。
 * 循环（loop）：在满足条件的情况下,重复执行同一段代码,比如while语句
 */
public class Tree_BFS {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, null);
        System.out.println("二叉树的层次遍历--非递归实现");
        printLine(root);
        System.out.println(" ");
        System.out.println("二叉树的层次遍历--分组--非递归实现");
        levelOrder(root);
        System.out.println(" ");
        System.out.println("二叉树的层次遍历--分组--递归实现");
        recursion_traversal(root);
        System.out.println(" ");
    }


    /**
     * 广度优先是一种横向的获取方式,先从树的较浅层开始获取节点,
     * 直接获取完同层次的所有页面后才进入下一层。
     * 层次遍历是广度优先遍历,层次遍历是二叉树按照从根节点到叶子节点的层次关系,
     * 一层一层横向遍历各个节点。
     * <p>
     * 思路
     * 层次遍历的非递归借助了队列实现,队列的特点是先进先出。
     * 首先访问根节点并进队,队列不为空时出队并输出节点的值,
     * 如果当前出队节点有左孩子则左孩子先进队,如果有右孩子则右孩子后进队
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
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
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
     * 递归实现 层次遍历
     * 深度优先遍历.
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     */
    public static List<List<Integer>> recursion_traversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 1, root);
        System.out.println(res);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int index, TreeNode root) {
        if (root == null) return;
        //假设res是[ [1],[2,3] ], index是3,就再插入一个空list放到res中
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        //将当前节点的值加入到res中,index代表当前层,假设index是3,节点值是99
        //res是[ [1],[2,3] [4] ],加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index - 1).add(root.val);
        //递归的处理左子树,右子树,同时将层数index+1
        dfs(res, index + 1, root.left);
        dfs(res, index + 1, root.right);
    }
}
