package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_迭代;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s2 = new Stack<>();

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);


            //s1--弹出加入--s2中

            //s2:
            //----------------------
            //  left right root    |
            //----------------------

            //s2--弹出
            //left-->right-->root
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
            //s1:
            //----------------------
            //  right left          |
            //----------------------
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
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode c;
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


    //```````````````高度    节点个数
    //``````1`````````1        1
    //````/```\```````
    //``2```````3`````2        3
    //`/`\`````/`\````
    //4```5```6```7```3        7
    public List<Integer> postorderTraversal_ReView1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        //left->right->root
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

}
