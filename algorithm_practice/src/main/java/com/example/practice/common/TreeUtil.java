package com.example.practice.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeUtil {


    /**
     * 得到一个颗树
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````/`\`
     * 4```5```6```7
     */
    public static TreeNode getTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    /**
     * 得到一个颗树的镜像
     * ``````1``````
     * ````/```\````
     * ``3```````2``
     * `/`\`````/`\`
     * 7```6```5```4
     */
    public static TreeNode getMirrorTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }


    /**
     * 得到一个颗二叉树的前序遍历结果
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private static void pre(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        pre(root.left, res);
        pre(root.right, res);
    }

    /**
     * 得到一个颗二叉树的中序遍历结果
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        in(root, res);
        return res;
    }

    private static void in(TreeNode root, List<Integer> res) {
        if (root == null) return;
        in(root.left, res);
        res.add(root.val);
        in(root.right, res);
    }


    /**
     * 得到一个颗二叉树的后序遍历结果
     */
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }

    private static void post(TreeNode root, List<Integer> res) {
        if (root == null) return;
        post(root.left, res);
        post(root.right, res);
        res.add(root.val);
    }

    /**
     * 得到一个颗二叉树的层次遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode rootNode) {

        //1.声明一个集合存储节点中的值元素
        List<List<Integer>> dataList = new ArrayList<>();
        if (rootNode == null) return dataList;

        //2.创建一个队列
        Queue<TreeNode> queue = new ArrayDeque<>();

        //3.队列中加入根节点
        queue.offer(rootNode);

        //4.开始循环,循环的终止条件是:队列中元素个数为0
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //5.取出队列中存储的第一个节点名为tempNode
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);

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
            dataList.add(levelList);
        }
        return dataList;
    }
}
