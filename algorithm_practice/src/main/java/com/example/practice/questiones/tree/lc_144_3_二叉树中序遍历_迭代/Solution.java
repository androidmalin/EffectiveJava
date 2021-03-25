package com.example.practice.questiones.tree.lc_144_3_二叉树中序遍历_迭代;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 实现:非递归
 */
public class Solution {


    /**
     * 中序遍历 非递归
     * <p>
     * 程序员代码面试指南 书籍写法
     * <p>
     * ``````1
     * ````/```\
     * ``2```````3
     * `/`\`````/`\
     * 4```5```6```7
     * <p>
     * 用非递归的方式实现二叉树的中序遍历，具体过程如下:
     * 1.申请一个新的栈，记为 stack。初始时，令变量 cur=head。
     * <p>
     * 2.先把 cur 节点压入栈中，对以 cur 节点为头节点的整棵子树来说，
     * 依次把左边界压入栈中，即不停地令 cur=cur.left，然后重复步骤 2。
     * <p>
     * 3.不断重复步骤 2，直到发现 cur 为空，此时从 stack 中弹出一个节点，记为 node。
     * 打印node 的值，并且让 cur=node.right，然后继续重复步骤 2。
     * <p>
     * 4.当 stack 为空且 cur 为空时，整个过程停止。
     * <p>
     * 还是用图 3-1 的例子来说明整个过程。
     * 初始时 cur 为节点 1，将节点 1 压入 stack，令 cur=cur.left，即 cur 变为节点 2。(步骤 1+步骤2)
     * cur 为节点 2，将节点 2 压入 stack，令 cur=cur.left，即 cur 变为节点 4。(步骤 2)
     * cur 为节点 4，将节点 4 压入 stack，令 cur=cur.left，即 cur 变为 null，此时 stack 从栈顶到栈 底为 4，2，1。(步骤 2)
     * cur 为 null，从 stack 弹出节点 4(node)并打印，令 cur=node.right，即 cur 为 null，此时 stack 从栈顶到栈底为 2，1。(步骤 3)
     * cur 为 null，从 stack 弹出节点 2(node)并打印，令 cur=node.right，即 cur 变为节点 5，此 时 stack 从栈顶到栈底为 1。(步骤 3)
     * cur 为节点 5，将节点 5 压入 stack，令 cur=cur.left，即 cur 变为 null，此时 stack 从栈顶到栈 底为 5，1。(步骤 2)
     * cur 为 null，从 stack 弹出节点 5(node)并打印，令 cur=node.right，即 cur 仍为 null，此时 stack 从栈顶到栈底为 1。(步骤 3)
     * cur 为 null，从 stack 弹出节点 1(node)并打印，令 cur=node.right，即 cur 变为节点 3，此 时 stack 为空。(步骤 3)
     * cur 为节点 3，将节点 3 压入 stack，令 cur=cur.left，即 cur 变为节点 6，此时 stack 从栈顶到 栈底为 3。(步骤 2)
     * cur 为节点 6，将节点 6 压入 stack，令 cur=cur.left，即 cur 变为 null，此时 stack 从栈顶到栈 底为 6，3。(步骤 2)
     * cur 为 null，从 stack 弹出节点 6(node)并打印，令 cur=node.right，即 cur 仍为 null，此时 stack 从栈顶到栈底为 3。(步骤 3)
     * cur 为 null，从 stack 弹出节点 3(node)并打印，令 cur=node.right，即 cur 变为节点 7，此 时 stack 为空。(步骤 3)
     * cur 为节点 7，将节点 7 压入 stack，令 cur=cur.left，即 cur 变为 null，此时 stack 从栈顶到栈 底为 7。(步骤 2)
     * cur 为 null，从 stack 弹出节点 7(node)并打印，令 cur=node.right，即 cur 仍为 null，此时 stack 为空。(步骤 3)
     * cur 为 null，stack 也为空，整个过程停止。(步骤 4)
     * 通过与例子结合的方式我们发现，步骤 1 到步骤 4 就是依次先打印左子树，然后打印每棵子树的头节点，最后打印右子树
     * <p>
     * <p>
     * 同样的思路详解:
     * 同理创建一个Stack，然后按 左 中 右的顺序输出节点。
     * 尽可能的将这个节点的左子树压入Stack，此时栈顶的元素是最左侧的元素，
     * 其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，并且在寻找的过程中记录了来源，才能返回上层,同时在返回上层的时候已经处理完毕左子树了。。
     * 当处理完最小单位的子树时，返回到上层处理了中间节点。
     * （如果把整个左中右的遍历都理解成子树的话，就是处理完 左子树->中间(就是一个节点)->右子树）如果有右节点，其也要进行中序遍历。
     * <p>
     * 当整个左子树退栈的时候这个时候输出了该子树的根节点 2，之后输出中间节点 1。然后处理根节点为3右子树。
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return res;
    }

    /**
     * 中序遍历--递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
