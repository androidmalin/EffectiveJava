package com.example.practice.questiones;

import com.example.practice.common.Node;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    //dfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }


    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;

        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            max = Math.max(depth, max);
        }
        return max + 1;
    }

    public int maxDepth2(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;

        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth2(node);
            max = Math.max(depth, max);
        }
        return max + 1;
    }


    public int maxDepth3(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int j = 0; node.children != null && j < node.children.size(); j++) {
                    if (node.children.get(j) != null) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth4(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.poll();
                if (temp.children != null && !temp.children.isEmpty()) {
                    for (Node node : temp.children) {
                        if (node != null) {
                            queue.offer(node);
                        }
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    @Test
    public void test() {
        Node node = new Node(1);
        node.children = new ArrayList<>(3);
        node.children.add(0, new Node(2, new ArrayList<>()));
        node.children.add(1, new Node(3, new ArrayList<>()));
        node.children.add(2, new Node(4, new ArrayList<>()));


        Solution solution = new Solution();
        assertEquals(2, solution.maxDepth(node));
        assertEquals(2, solution.maxDepth2(node));
        assertEquals(2, solution.maxDepth3(node));
        assertEquals(2, solution.maxDepth4(node));
    }
}
