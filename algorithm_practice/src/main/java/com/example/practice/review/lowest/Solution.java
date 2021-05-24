package com.example.practice.review.lowest;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Tree是一个相互关系.
 * 直接new TreeNode() 这个是孤立的一个, 没有左右子树的相关信息.
 */
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

    //1.parentNode map
    //2.visited set
    //3.define get parentNode map function
    //4.use visited set
    private final Map<Integer, TreeNode> parentNodeMap = new HashMap<>();
    private final Set<TreeNode> visited = new HashSet<>();

    /**
     * ***1
     * /    \
     * 2      3
     */
    public void makeParentNodeMap(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parentNodeMap.put(root.left.val, root);
            makeParentNodeMap(root.left);
        }
        if (root.right != null) {
            parentNodeMap.put(root.right.val, root);
            makeParentNodeMap(root.right);
        }
    }

    public TreeNode getLowestParentNode2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        makeParentNodeMap(root);
        while (p != null) {
            visited.add(p);
            p = parentNodeMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) return q;
            q = parentNodeMap.get(q.val);
        }
        return root;
    }


    public TreeNode getLowestParentNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = getLowestParentNode(root.left, p, q);
        TreeNode right = getLowestParentNode(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }


}
