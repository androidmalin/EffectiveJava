package com.example.practice.review;


import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> level(TreeNode root) {
        //1.检查参数
        if (root == null) return new ArrayList<>();

        //2.根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> lists = new ArrayList<>();

        //3.每次循环=>即:每次的节点加入一个集合
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                levelList.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            lists.add(levelList);
        }
        //4.返回结果
        return lists;
    }
}
