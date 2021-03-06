package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeNode;

public class Solution_M2 {

    /**
     * 深度优先搜索
     * 思路及解法
     * <p>
     * 首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
     * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(N) ，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(H) ，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
     * 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
     * <p>
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `````````/`\`
     * ````````6```7
     * <p>
     * website test pass ✅
     */
    public int minDepth(TreeNode root) {
        //DFS 深度优先遍历,一杆子插到底
        //递归终止条件
        //1.根节点
        //2.叶子节点
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int min = Integer.MAX_VALUE;

        //handle left
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }

        //handle right;
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
