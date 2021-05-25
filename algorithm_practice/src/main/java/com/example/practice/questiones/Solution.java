package com.example.practice.questiones;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        TreeOperation.show(root);

        //5,4=>2
        TreeNode lowestParentNode = solution.getLowestParentNode(root, root.left.right, root.left.left);
        Assertions.assertEquals(2, lowestParentNode.val);

        //5,6=>2
        TreeNode lowestParentNode1 = solution.getLowestParentNode(root, root.left.right, root.right.left);
        Assertions.assertEquals(1, lowestParentNode1.val);


        //4,7=>2
        TreeNode lowestParentNode2 = solution.getLowestParentNode(root, root.left.right, root.right.left);
        Assertions.assertEquals(1, lowestParentNode2.val);


        //5,2=>2
        TreeNode lowestParentNode3 = solution.getLowestParentNode(root, root.left.right, root.left);
        Assertions.assertEquals(2, lowestParentNode3.val);
    }

    private final Map<Integer, TreeNode> parentNode = new HashMap<>();
    private final Set<TreeNode> visited = new HashSet<>();

    public TreeNode getLowestParentNode(TreeNode root, TreeNode p, TreeNode q) {
        //1.边界条件判断
        if (root == null) return null;
        if (root == p || root == q) return root;
        //2.递归记录每个节点值,对应的parentNode
        dfs(root);
        //3.查找两个节点的交点
        while (p != null) {
            visited.add(p);
            p = parentNode.get(p.val);
        }
        //4.从p节点的parent中查找是否包含q
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parentNode.get(q.val);
        }
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parentNode.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentNode.put(root.right.val, root);
            dfs(root.right);
        }
    }

}
