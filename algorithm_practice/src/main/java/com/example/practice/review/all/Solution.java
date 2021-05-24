package com.example.practice.review.all;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    /**
     * 102.广度
     */
    @Test
    public void test_level() {
        TreeNode root = TreeUtil.getTreeNode();
        List<List<Integer>> list = TreeUtil.levelOrder(root);
        Solution solution = new Solution();
        List<List<Integer>> list2 = solution.levelOrder(root);
        Assertions.assertEquals(list, list2);
    }

    /**
     * 102.广度
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            res.add(levelList);
        }
        return res;
    }


    /**
     * 144.前序
     */
    @Test
    public void test_pre_order() {
        TreeNode root = TreeUtil.getTreeNode();
        List<Integer> list = TreeUtil.preOrder(root);
        List<Integer> list2 = new Solution().preorderTraversal(root);
        Assertions.assertTrue(ListUtil.<Integer>isSame(list, list2));
    }

    /**
     * 94.中序
     */
    @Test
    public void test_in_order() {
        TreeNode root = TreeUtil.getTreeNode();
        List<Integer> list1 = TreeUtil.inOrder(root);
        List<Integer> list2 = new Solution().inorderTraversal(root);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }

    /**
     * 145.后序
     */
    @Test
    public void test_post_order() {
        TreeNode root = TreeUtil.getTreeNode();
        List<Integer> list1 = TreeUtil.postOrder(root);
        List<Integer> list2 = new Solution().postorderTraversal(root);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test_color_pre() {
        TreeNode root = TreeUtil.getTreeNode();
        List<Integer> list1 = TreeUtil.preOrder(root);
        List<Integer> list2 = new Solution().color_preOrder(root);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }


    @Test
    public void test_invertTree() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeNode mirrorTreeNode = TreeUtil.getMirrorTreeNode();

        Solution solution = new Solution();
        TreeNode mirror = solution.invertTree(root);

        TreeUtil.isSameTree(mirrorTreeNode, mirror);
    }


    /**
     * 144.前序
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //root->left->right
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            list.add(tempNode.val);
            if (tempNode.right != null) stack.push(tempNode.right);
            if (tempNode.left != null) stack.push(tempNode.left);
        }
        return list;
    }

    /**
     * 94.中序
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode tempNode = stack.pop();
            list.add(tempNode.val);
            currentNode = tempNode.right;
        }
        return list;
    }

    /**
     * 145.后序
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack2 = new Stack<>();

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }


    /**
     * 144.前序
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
     */
    public List<Integer> color_preOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //color
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                TreeNode temp = (TreeNode) object;
                //root=>left=>right;
                stack.push(temp.right);
                stack.push(temp.left);
                stack.push(temp.val);
            } else if (object instanceof Integer) {
                list.add((Integer) object);
            }
        }
        return list;
    }

    /**
     * 226.翻转二叉树
     * https://leetcode-cn.com/problems/invert-binary-tree/
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            swap(tempNode);
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 101.对称
     * https://leetcode-cn.com/problems/symmetric-tree/submissions/
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        if (p.val != q.val) return false;
        return symmetric(p.left, q.right) && symmetric(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null ^ root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null ^ q == null) return false;
            if (p.val != q.val) return false;
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

    /**
     * 100. same-tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        if (p.val != q.val) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null ^ temp2 == null) return false;
            if (temp1.val != temp2.val) return false;
            queue.offer(temp1.left);
            queue.offer(temp2.left);
            queue.offer(temp1.right);
            queue.offer(temp2.right);
        }
        return true;
    }

    @Test
    public void main2() {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.getTreeNode();
        boolean binary = solution.isValidBST(root);
        System.out.println(binary);
        TreeNode root1 = TreeCreateFactory.init(2, 1, 3);
        boolean binary1 = solution.isValidBST(root1);
        System.out.println(binary1);
        boolean binary2 = solution.isValidBST2(root1);
        System.out.println(binary2);
    }


    @Test
    public void test_validBST() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        boolean binary = solution.isValidBST(root);
        Assertions.assertFalse(binary);


        TreeNode root2 = TreeUtil.getBinaryTreeNode();
        boolean binary2 = solution.isValidBST(root2);
        Assertions.assertTrue(binary2);

        TreeNode root3 = null;
        boolean binary3 = solution.isValidBST(root3);
        Assertions.assertTrue(binary3);


        TreeNode root4 = new TreeNode(Integer.MIN_VALUE);
        boolean binary4 = solution.isValidBST(root4);
        Assertions.assertTrue(binary4);
    }

    @Test
    public void test_validBST2() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        boolean binary = solution.isValidBST2(root);
        Assertions.assertFalse(binary);

        TreeNode root1 = TreeUtil.getBinaryTreeNode();
        boolean binary1 = solution.isValidBST2(root1);
        Assertions.assertTrue(binary1);

        TreeNode root2 = null;
        boolean binary2 = solution.isValidBST2(root2);
        Assertions.assertTrue(binary2);

        TreeNode root3 = new TreeNode(Integer.MIN_VALUE);
        boolean binary3 = solution.isValidBST2(root3);
        Assertions.assertTrue(binary3);

    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isBin(root, null, null);
    }

    private boolean isBin(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        boolean left = isBin(root.left, min, root.val);
        boolean right = isBin(root.right, root.val, max);
        return left && right;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) {
                return false;
            }
            pre = temp.val;
            cur = temp.right;
        }
        return true;
    }

    @Test
    public void test_is_completeTree() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, null, 6, 7);
        boolean completeTree = solution.isCompleteTree(root);
        Assertions.assertFalse(completeTree);

        TreeNode root2 = TreeUtil.getCompleteTree();
        boolean completeTree2 = solution.isCompleteTree(root2);
        Assertions.assertTrue(completeTree2);
    }


    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reach = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                reach = true;
                continue;
            }
            if (reach) {
                if (temp != null) {
                    return false;
                }
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return true;
    }


    @Test
    public void test_is_completeTree2() {
        TreeNode root = TreeCreateFactory.init(true, 1, 2, 3, 4);
        Solution solution = new Solution();
        boolean complete = solution.isCompleteTree2(root);
        Assertions.assertTrue(complete);
    }


    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) return true;
        int totalNum = countNumber(root);
        return checkChild(totalNum, 1, root);
    }


    public int countNumber(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNumber(root.left) + countNumber(root.right);
    }

    private boolean checkChild(int total, int idx, TreeNode root) {
        //left = 2*level
        //right = 2*level + 1;
        if (root == null) return true;
        if (idx > total) return false;
        return checkChild(total, 2 * idx, root.left) && checkChild(total, 2 * idx + 1, root.right);
    }

    @Test
    public void test_depth() {
        Solution solution = new Solution();
        TreeNode root = null;
        int depth = solution.maxDepth(root);
        System.out.println(depth);

        TreeNode root2 = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        int depth2 = solution.maxDepth(root2);
        System.out.println(depth2);
    }


    @Test
    public void test_depth2() {
        Solution solution = new Solution();
        TreeNode root = null;
        int depth = solution.maxDepth2(root);
        System.out.println(depth);

        TreeNode root2 = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        int depth2 = solution.maxDepth2(root2);
        System.out.println(depth2);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
            depth++;
        }
        return depth;
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) return depth + 1;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }


    @Test
    public void test_min_depth() {

        Solution solution = new Solution();

        TreeNode root0 = null;
        int i = solution.minDepth(root0);
        Assertions.assertEquals(0, i);

        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertEquals(3, solution.minDepth(root));

        TreeNode root1 = TreeCreateFactory.init(1, null, 3, 4, 5, 6, 7);

        Assertions.assertEquals(3, solution.minDepth(root1));


        TreeNode root2 = TreeCreateFactory.init(1, 2, null, 4, 5, 6, 7);
        Assertions.assertEquals(3, solution.minDepth(root2));
    }

    @Test
    public void test_min_depth2() {

        Solution solution = new Solution();
        TreeNode root0 = null;
        int i = solution.minDepth2(root0);
        Assertions.assertEquals(0, i);

        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertEquals(3, solution.minDepth2(root));

        TreeNode root1 = TreeCreateFactory.init(1, null, 3, 4, 5, 6, 7);
        System.out.println(solution.minDepth2(root1));

        Assertions.assertEquals(3, solution.minDepth2(root1));


        TreeNode root2 = TreeCreateFactory.init(1, 2, null, 4, 5, 6, 7);
        Assertions.assertEquals(3, solution.minDepth2(root2));
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if (root.left != null && root.right == null) return left + 1;
        if (root.left == null && root.right != null) return right + 1;
        return Math.min(left, right) + 1;
    }


    @Test
    public void test_count() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        int i = solution.countNumber(root);
        Assertions.assertEquals(7, i);

        TreeNode root1 = TreeCreateFactory.init(false, 1, null, 3, 4, 5, 6, 7);
        int i1 = solution.countNumber(root1);
        Assertions.assertEquals(4, i1);

        TreeNode root2 = null;
        int i2 = solution.countNumber(root2);
        Assertions.assertEquals(0, i2);
    }

    public int countNum(TreeNode root) {
        if (root == null) return 0;
        return countNumber(root.left) + countNumber(root.right) + 1;
    }

}
