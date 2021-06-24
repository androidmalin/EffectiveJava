package com.example.practice.questiones.huisu.lc_129_求根节点到叶节点数字之和;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {

    /**
     * 使用广度优先搜索，需要维护两个队列，分别存储节点和节点对应的数字。
     * <p>
     * 初始时，将根节点和根节点的值分别加入两个队列。
     * 每次从两个队列分别取出一个节点和一个数字，进行如下操作：
     * <p>
     * - 如果当前节点是叶子节点，则将该节点对应的数字加到数字之和；
     * - 如果当前节点不是叶子节点，则获得当前节点的非空子节点，
     * 并根据当前节点对应的数字和子节点的值计算子节点对应的数字，然后将子节点和子节点对应的数字分别加入两个队列。
     * <p>
     * 搜索结束后，即可得到所有叶子节点对应的数字之和。
     */
    @SuppressWarnings("ConstantConditions")
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.poll();
            int value = valueQueue.poll();
            if (temp.left == null && temp.right == null) {
                sum = sum + value;
            } else {
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                    valueQueue.offer(value * 10 + temp.left.val);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                    valueQueue.offer(value * 10 + temp.right.val);
                }
            }
        }
        return sum;
    }
}
