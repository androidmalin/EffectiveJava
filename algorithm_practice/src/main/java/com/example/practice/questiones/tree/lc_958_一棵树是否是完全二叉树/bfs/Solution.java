package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * <p>
 * 百度百科中对完全二叉树的定义如下：
 * <p>
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~2h个节点。）
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```````3``
 * `/`\`````/```
 * 4```5```6````
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * <p>
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/ceng-xu-bian-li-by-dian-dao-de-hu-die-681d/
 */
public class Solution {

    /**
     * 完全二叉树 进行层序遍历时，在最后一个节点之后，队列中的所有节点都应为空。
     * 完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
     * https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205768/Java-easy-Level-Order-Traversal-one-while-loop
     * <p>
     * website test pass ✅
     */
    public boolean isCompleteTree(TreeNode root) {
        boolean reachedEnd = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                reachedEnd = true;
            } else {
                if (reachedEnd) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
