package com.example.practice.questiones.huisu.lc_257_所有根节点到叶子节点的路径;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * **1
 * /   \
 * 2     3
 * *\
 * **5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder path_sb = new StringBuilder(path);
            path_sb.append(root.val);
            if (root.left == null && root.right == null) {
                // 当前节点是叶子节点
                // 把路径加入到答案中
                paths.add(path_sb.toString());
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                path_sb.append("->");
                constructPaths(root.left, path_sb.toString(), paths);
                constructPaths(root.right, path_sb.toString(), paths);
            }
        }
    }
}
