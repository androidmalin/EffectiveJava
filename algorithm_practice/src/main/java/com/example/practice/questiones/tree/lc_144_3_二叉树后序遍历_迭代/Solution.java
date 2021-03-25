package com.example.practice.questiones.tree.lc_144_3_二叉树后序遍历_迭代;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Solution {


    /**
     * 后序遍历 非递归
     * <p>
     * 程序员代码面试指南 书籍写法
     * <p>
     * ``````1
     * ````/```\
     * ``2```````3
     * `/`\`````/`\
     * 4```5```6```7
     * <p>
     * <p>
     * 用非递归的方式实现二叉树的后序遍历。用两个栈实现后序遍历的过程，具体过程如下:
     * 1.申请一个栈，记为 s1，然后将头节点 head 压入 s1 中。
     * 2.从 s1 中弹出的节点记为 cur，然后依次将 cur 的左孩子节点和右孩子节点压入 s1 中。
     * 3.在整个过程中，每一个从 s1 中弹出的节点都放进 s2 中。
     * 4.不断重复步骤 2 和步骤 3，直到 s1 为空，过程停止。
     * 5.从 s2 中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s2 = new Stack<>();

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            //s1:
            //2:right
            //1:left

            //s1--弹出加入--s2中

            //s2:
            //3:left
            //2:right
            //1:root

            //s2--弹出
            //left-->right-->root
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s1.push(root.right);
        }

        while (!s2.isEmpty()) res.add(s2.pop().val);
        return res;
    }


    /**
     * 后序遍历 非递归2
     * <p>
     * 程序员代码面试指南 书籍写法
     * <p>
     * ``````1
     * ````/```\
     * ``2```````3
     * `/`\`````/`\
     * 4```5```6```7
     * <p>
     * <p>
     * `````` 1
     * ```` /```\
     * ``h 2```````3
     * <p>
     * 只用一个栈实现后序遍历的过程，具体过程如下。
     * 1.申请一个栈，记为 stack，将头节点压入 stack，同时设置两个变量 h 和 c。
     * 在整个流程 中，h 代表最近一次弹出并打印的节点，c 代表 stack 的栈顶节点，初始时 h 为头节点，c 为 null。
     * <p>
     * 2.每次令 c 等于当前 stack 的栈顶节点，但是不从 stack 中弹出，此时分以下三种情况。
     * <p>
     * 1 如果 c 的左孩子节点不为 null，并且 h 不等于c的左孩子节点，也不等于 c 的右孩子节 点，则把 c 的左孩子节点压入 stack 中。
     * 具体解释一下这么做的原因，首先 h 的意义是最近一次弹出并打印的节点，
     * 所以，如果h等于c的左孩子节点或者右孩子节点，说明c的左子树与右子树已经打印完毕，此时不应该再将c的左孩子节点放入stack 中。
     * 否则，说明左子树还没处理过，那么此时将c的左孩子节点压入stack 中。
     * <p>
     * 2 如果条件1不成立，并且 c 的右孩子节点不为 null，h 不等于 c 的右孩子节点，则把 c 的右孩子节点压入 stack 中。
     * 含义是如果 h 等于 c 的右孩子节点，说明 c 的右子树已经打印完毕， 此时不应该再将 c 的右孩子节点放入 stack 中。
     * 否则，说明右子树还没处理过，此时将 c 的右孩 子节点压入 stack 中。
     * <p>
     * 3 如果条件1和条件2都不成立，说明 c 的左子树和右子树都已经打印完毕，那么从 stack 中弹出 c 并打印，然后令 h=c。
     * 3.一直重复步骤 2，直到 stack 为空，过程停止。
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode c = null;
        TreeNode h = root;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                res.add(stack.pop().val);
                h = c;
            }
        }
        return res;
    }

    /**
     * 后序遍历--递归
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        inorder(root.right, res);
        res.add(root.val);
    }


    public List<Integer> preorderTraversal5(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s2 = new Stack<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }


}
