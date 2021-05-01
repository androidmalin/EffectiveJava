package com.example.practice;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

/**
 * 1.Tree是一个相互关系.
 * 直接new TreeNode() 这个是孤立的一个, 没有左右子树的相关信息.
 * 2.TreeCreateFactory 这个类中的成员变量是static的需要注意.
 */
public class Client {

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4);
        TreeOperation.show(root);
    }
}
