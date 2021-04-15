package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.jian_32_III;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
@SuppressWarnings("all")
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (lists.size() % 2 == 0) {
                    //层数root为0层, 依次递增
                    //偶数 加到队尾
                    System.out.println("偶数:" + lists.size());
                    levelList.addLast(tempNode.val);
                } else {
                    //层数root为0层, 依次递增
                    //奇数 加到队首
                    System.out.println("奇数:" + lists.size());
                    levelList.addFirst(tempNode.val);
                }
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            lists.add(levelList);
        }
        return lists;
    }
}
