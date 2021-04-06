package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_BFS_迭代;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 *
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```````3``
 * `/`\`````/`\`
 * 4```5```6```7
 * <p>
 * To
 * <p>
 * ``````1``````
 * ````/```\````
 * ``3```````2``
 * `/`\`````/`\`
 * 7```6```5```4
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Solution {

    /**
     * 深度优先遍历的特点是一竿子插到底，不行了再退回来继续；而广度优先遍历的特点是层层扫荡。
     * 所以，我们需要先将根节点放入到队列中，然后不断的迭代队列中的元素。
     * 对当前元素调换其左右子树的位置，然后：
     * <p>
     * 判断其左子树是否为空，不为空就放入队列中
     * 判断其右子树是否为空，不为空就放入队列中
     * <p>
     * https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            swap(currentNode);
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }
        return root;
    }

    private void swap(TreeNode currentNode) {
        TreeNode tempNode = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = tempNode;
    }
}
