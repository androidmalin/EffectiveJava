package com.example.practice.questiones._true.lc_236_二叉树的最近公共祖先.dfs2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    @Test
    public void main() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeOperation.show(root);

        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;

        Solution solution = new Solution();
        TreeNode node = solution.lowestCommonAncestor(root, p, q);
        boolean sameTree = TreeUtil.isSameTree(root.left, node);
        Assertions.assertTrue(sameTree);

        System.out.println(" ");
        System.out.println("p:" + p + ",q:" + q + " lowestCommonAncestor=>" + node);

        Solution2 solution2 = new Solution2();
        TreeNode resultNode = solution2.lowestCommonAncestor(root, p, q);
        boolean sameTree1 = TreeUtil.isSameTree(resultNode, root.left);
        Assertions.assertTrue(sameTree1);

        Solution3 solution3 = new Solution3();
        TreeNode node1 = solution3.lowestCommonAncestor(root, p, q);
        boolean sameTree2 = TreeUtil.isSameTree(node1, root.left);
        Assertions.assertTrue(sameTree2);

        Solution4 solution4 = new Solution4();
        TreeNode node2 = solution4.lowestCommonAncestor(root, p, q);
        boolean sameTree3 = TreeUtil.isSameTree(node2, root.left);
        Assertions.assertTrue(sameTree3);

        Solution5 solution5 = new Solution5();
        TreeNode node3 = solution5.lowestCommonAncestor(root, p, q);
        boolean sameTree4 = TreeUtil.isSameTree(node3, root.left);
        Assertions.assertTrue(sameTree4);

        Solution6 solution6 = new Solution6();
        TreeNode node4 = solution6.lowestCommonAncestor(root, p, q);
        boolean sameTree5 = TreeUtil.isSameTree(node4, root.left);
        Assertions.assertTrue(sameTree5);
    }


    public static class Solution2 {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }
    }

    public static class Solution3 {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                //p ==> p parent node
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                // q ==> q parent node
                q = parent.get(q.val);
            }
            return null;
        }

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }
    }

    public static class Solution4 {

        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }

    public static class Solution5 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == q || root == p) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null) return null;
            if (left == null && right != null) return right;
            if (left != null && right == null) return left;
            return root;
        }

        public TreeNode getBinaryNode(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val > root.val && q.val > root.val) {
                return getBinaryNode(root.right, p, q);
            }
            if (p.val < root.val && q.val < root.val) {
                return getBinaryNode(root.left, p, q);
            }
            return root;
        }

    }

    public static class Solution6 {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }


    public static class Solution7 {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode getLowestNode(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }


    }

    public static class Solution8 {
        //1.preOrder,inOrder,postOrder
        //2.bfs
        //3.dfs
        //4.complete tree
        //5.balance tree
        //6.binary tree
        //7.max height
        //8.min height
        //9.revert tree
        //10.same tree
        //11.tree is not mirror
        //12.lowest parent tree
        //13.binary tree lowest parent tree
        //14.xx

        /**
         * 110. 平衡二叉树
         * https://leetcode-cn.com/problems/balanced-binary-tree/submissions/
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            boolean abs = Math.abs(height(root.left) - height(root.right)) <= 1;
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return abs && left && right;
        }

        public int height(TreeNode root) {
            if (root == null) return 0;
            return Math.max(height(root.left), height(root.right)) + 1;
        }


        /**
         * TODO:练习
         * 958. 二叉树的完全性检验
         * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
         */
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean reach = false;
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    reach = true;
                } else {
                    if (reach) return false;
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
            return true;
        }

        /**
         * TODO:练习
         * 958. 二叉树的完全性检验
         * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
         */
        public boolean isCompleteTree2(TreeNode root) {
            if (root == null) return true;
            int total = countNode(root);
            return com(1, total, root);
        }

        public boolean com(int idx, int total, TreeNode root) {
            if (root == null) return true;
            if (idx > total) return false;
            boolean left = com(idx * 2, total, root.left);
            boolean right = com(idx * 2 + 1, total, root.right);
            return left && right;
        }

        public int countNode(TreeNode root) {
            if (root == null) return 0;
            return countNode(root.left) + countNode(root.right) + 1;
        }

        @Test
        public void test1() {
            TreeNode root = TreeCreateFactory.init(2, 1, 3);
            Solution8 solution8 = new Solution8();
            boolean validBST = solution8.isValidBST(root);
            System.out.println(validBST);

        }

        /**
         * TODO:练习
         * 98. 验证二叉搜索树
         * https://leetcode-cn.com/problems/validate-binary-search-tree/
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) return false;
            double pre = -Double.MAX_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode temp = stack.pop();
                if (temp.val <= pre) return false;
                pre = temp.val;
                cur = temp.right;
            }
            return true;
        }

        public boolean isValidBST2(TreeNode root) {
            if (root == null) return false;
            return binaryChild(null, null, root);
        }

        public boolean binaryChild(Integer min, Integer max, TreeNode root) {
            if (root == null) return true;
            if (min != null && root.val <= min) return false;
            if (max != null && root.val >= max) return false;
            return binaryChild(min, root.val, root.left) && binaryChild(root.val, max, root.right);
        }


        /**
         * 104. 二叉树的最大深度
         * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        /**
         * 111. 二叉树的最小深度
         * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
         */
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (root.left == null ^ root.right == null) return left + right + 1;
            return Math.min(left, right) + 1;
        }

        /**
         * 226. 翻转二叉树
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

        /**
         * 100. 相同的树
         * https://leetcode-cn.com/problems/same-tree/
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (q == null && p == null) return true;
            if (q == null ^ p == null) return false;
            if (q.val != p.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


        /**
         * 101. 对称二叉树
         * https://leetcode-cn.com/problems/symmetric-tree/
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return mmChild(root.left, root.right);
        }

        public boolean mmChild(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null ^ q == null) return false;
            if (p.val != q.val) return false;
            return mmChild(p.left, q.right) && mmChild(p.right, q.left);
        }


        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode q, TreeNode p) {
            if (root == null) return root;
            return getChildNode(root, q, p);
        }

        public TreeNode getChildNode(TreeNode root, TreeNode q, TreeNode p) {
            if (root == null) return null;
            if (root == q || root == p) return root;
            TreeNode left = getChildNode(root.left, q, p);
            TreeNode right = getChildNode(root.right, q, p);
            if (left == null && right == null) return null;
            if (left == null && right != null) return right;
            if (left != null && right == null) return left;
            return root;
        }
    }
}
