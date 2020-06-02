package com.eknv.algorithms.tree;

import com.eknv.algorithms.tree.model.TreeNode;

public class FindMinInBST {

    private FindMinInBST() {
    }

    public static int execute(TreeNode<Integer> root) {

        if (root == null) {
            return -1;
        }

        TreeNode<Integer> minimum = root;

        while (minimum.getLeftChild() != null) {
            minimum = minimum.getLeftChild();
        }

        return minimum.getData();
    }

}
