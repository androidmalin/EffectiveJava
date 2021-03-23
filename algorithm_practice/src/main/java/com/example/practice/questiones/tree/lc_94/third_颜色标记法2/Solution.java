package com.example.practice.questiones.tree.lc_94.third_颜色标记法2;

import com.example.practice.common.TreeNode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 非递归写法
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了42.30%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了70.47%的用户
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/562336
 */
public class Solution {
    enum Color {
        WHITE, BLACK
    }

    private Map.Entry<Color, TreeNode> createEntry(Color color, TreeNode node) {
        return new AbstractMap.SimpleEntry<>(color, node);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Map.Entry<Color, TreeNode>> stack = new Stack<>();
        stack.add(createEntry(Color.WHITE, root));
        while (!stack.isEmpty()) {
            Map.Entry<Color, TreeNode> node = stack.pop();
            if (node.getValue() == null) continue;
            if (node.getKey() == Color.WHITE) {
                stack.add(createEntry(Color.WHITE, node.getValue().right)); // 右
                stack.add(createEntry(Color.BLACK, node.getValue()));  // 中
                stack.add(createEntry(Color.WHITE, node.getValue().left)); // 左
            } else {
                res.add(node.getValue().val);
            }
        }
        return res;
    }
}