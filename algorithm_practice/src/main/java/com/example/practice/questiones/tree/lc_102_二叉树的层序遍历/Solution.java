package com.example.practice.questiones.tree.lc_102_二叉树的层序遍历;

import com.example.practice.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 实现:非递归写法
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * pass
 */
public class Solution {

    /**
     * 广度优先遍历
     * BFS + 非递归写法
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/san-chong-shi-xian-tu-jie-107er-cha-shu-de-ceng-ci/
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     */
    public List<List<Integer>> levelOrder(TreeNode rootNode) {

        //1.声明一个集合存储节点中的值元素
        List<List<Integer>> dataList = new ArrayList<>();
        if (rootNode == null) return dataList;

        //2.创建一个队列
        Queue<TreeNode> queue = new ArrayDeque<>();

        //3.队列中加入根节点
        queue.offer(rootNode);

        //4.开始循环,循环的终止条件是:队列中元素个数为0
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //5.取出队列中存储的第一个节点名为tempNode
                TreeNode tempNode = queue.poll();
                list.add(tempNode.val);

                //6.加入tempNode该节点的左子节点到队列(如果左子节点不为空)
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                //7.加入tempNode该节点的右子节点到队列(如果右子节点不为空)
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            //8.当前节点的值加入集合中
            dataList.add(list);
        }
        return dataList;
    }
}
