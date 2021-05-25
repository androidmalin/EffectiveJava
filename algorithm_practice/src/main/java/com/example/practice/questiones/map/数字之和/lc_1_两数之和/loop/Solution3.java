package com.example.practice.questiones.map.数字之和.lc_1_两数之和.loop;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//TODO:两数字之和--迭代
public class Solution3 {
    /**
     * nums = [2,7,11,15], target = 9
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */

    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] getSum2(int[] nums, int targetSum) {
        int[] res = new int[2];
        if (nums == null) return res;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == targetSum) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    @Test
    public void test2() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] actual = new Solution().twoSum(nums, target);

        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        int[] array = {0, 1, 2, 3, 4, 5};
        int target = 1;
        Solution3 solution3 = new Solution3();
        int[] ints = solution3.twoSum(array, target);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test11() {
        Solution3 solution3 = new Solution3();
        TreeUtil.isBalancedTree(null);
    }

    public boolean binary(TreeNode root) {
        if (root == null) return false;
        double pre = -Double.MAX_VALUE;
        //inorder
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode temp = stack.pop();

            if (temp.val <= pre) return false;
            currentNode = temp.right;
        }
        return true;
    }

    public boolean binary2(TreeNode root) {
        //1.inorder = stack , currentNode
        //2. pre double max
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) return false;
            currentNode = temp.right;

        }
        return false;
    }

    public boolean binary3(TreeNode root) {
        //1.inorder = stack , currentNode
        //2. pre double max
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) return false;
            currentNode = temp.right;
        }
        return true;
    }

    public boolean binary4(TreeNode root) {
        //1.inorder = stack , currentNode
        //2. pre double max
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) return false;
            currentNode = temp.right;
        }

        return true;
    }

    public boolean isComplete(TreeNode root) {
        if (root == null) return true;
        //level print
        //null
        //!=null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reach = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
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
                size--;
            }
        }
        return true;
    }

    public boolean isComplete2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reach = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    reach = true;
                } else {
                    if (reach) return false;
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
                size--;
            }
        }
        return true;
    }

    public TreeNode getLowestTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = getLowestTreeNode(root.left, p, q);
        TreeNode right = getLowestTreeNode(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return root;
    }

    public static class Solution2 {
        Map<Integer, TreeNode> parentNode = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parentNode.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parentNode.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode getChild(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parentNode.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parentNode.get(q.val);
            }
            return null;
        }
    }

    public boolean balance(TreeNode root) {
        if (root == null) return true;
        boolean abs = Math.abs(height(root.left) - height(root.right)) <= 1;
        boolean left = balance(root.left);
        boolean right = balance(root.right);
        return abs && left && right;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isComplete3(TreeNode root) {
        if (root == null) return true;
        int total = countNode(root);
        return isChildComplete(1, total, root);
    }

    public boolean isChildComplete(int idx, int sum, TreeNode root) {
        if (root == null) return true;
        if (idx > sum) return false;
        boolean left = isChildComplete(2 * idx, sum, root.left);
        boolean right = isChildComplete(2 * idx + 1, sum, root.right);
        return left && right;
    }

    public int countNode(TreeNode root) {
        if (root == null) return 0;
        return countNode(root.left) + countNode(root.right) + 1;
    }

    public int min(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) return depth + 1;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
            depth++;
        }
        return depth;
    }

    @Test
    public void test_min() {
        TreeNode root = TreeCreateFactory.init(false, 1, null, 3);
        TreeOperation.show(root);
        Solution3 solution3 = new Solution3();
        int min = solution3.min(root);
        System.out.println(min);
        Assertions.assertEquals(2, min);
    }


    public int[] getTwoSum(int[] nums, int targetSum) {


        return null;
    }

    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
}
