package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_迭代;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 实现:非递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {


    /**
     * 前序遍历 非递归
     * <p>
     * 首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，所以我们优先将头结点加入Stack，然后打印。
     * <p>
     * 之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
     * 此时你能得到的流程如下:
     * <p>
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
     * <p>
     * <p>
     * 程序员代码面试指南 书籍写法
     * 1.申请一个新的栈，记为 stack。然后将根节点 root 压入 stack 中。
     * <p>
     * 2.从 stack 中弹出栈顶节点，记为 cur，然后打印 cur 节点的值，
     * 再将节点 cur 的右孩子节点(不为空的话)先压入 stack 中，
     * 最后将 cur 的左孩子节点(不为空的话)压入 stack 中。
     * <p>
     * 3.不断重复步骤 2，直到 stack 为空，全部过程结束。
     * 下面举例说明整个过程，一棵二叉树如图所示。
     * ``````1
     * ````/```\
     * ``2```````3
     * `/`\`````/`\
     * 4```5```6```7
     * 节点 1 先入栈，然后弹出并打印。接下来先把节点 3 压入 stack，再把节点 2 压入，stack 从栈顶到栈底依次为 2，3。
     * 节点 2 弹出并打印，把节点 5 压入 stack，再把节点 4 压入，stack 从栈顶到栈底为 4，5，3。
     * 节点 4 弹出并打印，节点 4 没有孩子节点压入 stack，stack 从栈顶到栈底依次为 5，3。
     * 节点 5 弹出并打印，节点 5 没有孩子节点压入 stack，stack 从栈顶到栈底依次为 3。
     * 节点 3 弹出并打印，把节点 7 压入 stack，再把节点 6 压入，stack 从栈顶到栈底为 6，7。
     * 节点 6 弹出并打印，节点 6 没有孩子节点压入 stack，stack 目前从栈顶到栈底为 7。
     * 节点 7 弹出并打印，节点 7 没有孩子节点压入 stack，stack 已经为空，过程停止。
     * 整个过程请参看如下代码中的 preorderTraversal 方法。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //root->left->right
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

    /**
     * 递归写法
     */
    public List<Integer> preorderTraversalDG(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
