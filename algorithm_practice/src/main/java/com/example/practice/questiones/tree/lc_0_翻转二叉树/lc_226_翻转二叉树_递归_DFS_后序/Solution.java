package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

import com.example.practice.common.TreeNode;

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
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/shou-hua-tu-jie-san-chong-xie-fa-di-gui-liang-chon/
 */
@SuppressWarnings("all")
public class Solution {

    /**
     * 基于DFS(深度优先遍历)的后序遍历：
     * 后序遍历：将「处理当前节点」放到「递归左右子树」之后。
     * 这个「处理当前节点」，就是交换左右子树
     * TreeNode temp = root.left;
     * root.left = root.right;
     * root.right = temp;
     * <p>
     * 递归只是帮你遍历这棵树，核心还是解决问题的代码，递归把它应用到每个子树上，解决每个子问题，最后解决整个问题。
     * <p>
     * 你可以选择将 “做事” 的代码，放到 DFS 过程中的一个合适的时间点，而已。
     * https://leetcode-cn.com/problems/invert-binary-tree/solution/shou-hua-tu-jie-san-chong-xie-fa-di-gui-liang-chon/
     *
     *
     * <p>
     * 我们从根节点开始，递归地对树进行遍历，并从叶子结点先开始翻转。
     * <p>
     * 如果当前遍历到的节点root 的左右两棵子树都已经翻转，
     * 那么我们只需要交换两棵子树的位置，即可完成以root为根节点的整棵子树的翻转。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 NN 为二叉树节点的数目。
     * 我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
     * <p>
     * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。
     * 在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logN)。而在最坏情况下，树形成链状，空间复杂度为O(N)。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
